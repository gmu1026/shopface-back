package com.dreamsecurity.shopface.member;

import com.dreamsecurity.shopface.alarm.Alarm;
import com.dreamsecurity.shopface.alarm.AlarmMapper;
import com.dreamsecurity.shopface.businessman.branch.Branch;
import com.dreamsecurity.shopface.businessman.branch.BranchMapper;
import com.dreamsecurity.shopface.employ.Employ;
import com.dreamsecurity.shopface.employ.EmployMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.net.ssl.HttpsURLConnection;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
    private final EmployMapper employMapper;
    private final AlarmMapper alarmMapper;
    private final BranchMapper branchMapper;

    @Transactional
    @Override
    public HttpStatus addMember(Member member, String certiCode) {
        HttpStatus status = null;
        boolean isSuccess = false;

        if (!member.getId().equals("")
                && !member.getName().equals("")
                && !member.getPassword().equals("")
                && !member.getPhone().equals("")) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            memberMapper.insert(member);

            if (!"".equals(certiCode)) {
                Employ existEmploy = employMapper.select(Employ.builder()
                                                                .certiCode(certiCode)
                                                                .build());

                employMapper.update(Employ.builder()
                                            .no(existEmploy.getNo())
                                            .memberId(member.getId())
                                            .employDate(new Date(Calendar.getInstance().getTime().getTime()))
                                            .certiCode(null)
                                            .state('C')
                                            .build());

                Branch existBranch = branchMapper.select(existEmploy.getBranchNo());

                alarmMapper.insert(Alarm.builder()
                                        .addresseeId(existBranch.getMemberId())
                                        .contents(member.getName() + "- 근무자가 합류했습니다.")
                                        .type("근무자 합류")
                                        .build());
            }

            status = HttpStatus.CREATED;
        } else {// 400 : bad request
            status = HttpStatus.BAD_REQUEST;
        }

        return status;
    }

    @Transactional
    @Override
    public boolean checkIdDuplicate(String id) {
        boolean isDuplicate = false;

        Member existMember = memberMapper.select(Member.builder()
                                                        .id(id)
                                                        .build());
        if (existMember != null) {
            isDuplicate = true;
        }

        return isDuplicate;
    }

    @Transactional
    @Override
    public List<Member> getMemberList(Member member) {
        return memberMapper.selectAll(member);
    }

    @Transactional
    @Override
    public Member getMember(Member member) {
        return memberMapper.select(member);
    }

    @Transactional
    @Override
    public HttpStatus editMember(Member member, String oldPassword) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        boolean isSuccess = false;

        Member existMember = memberMapper.select(member);
        if (existMember != null) {
            if (oldPassword == null || "".equals(oldPassword)) {
                memberMapper.update(member);

                status = HttpStatus.OK;
            }

            if (member.getPassword() != null) {
                if (existMember.getPassword().equals(oldPassword)) {
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    member.setPassword(passwordEncoder.encode(member.getPassword()));

                    memberMapper.update(member);

                    status = HttpStatus.OK;
                    isSuccess = true;
                } else {
                    memberMapper.update(member);

                    status = HttpStatus.OK;
                }
            }
        }

        return status;
    }

    @Transactional
    @Override
    public HttpStatus removeMember(Member member) {
        HttpStatus status = HttpStatus.OK;
        if (member.getId() != null
                && memberMapper.select(member) != null) {
            member.setState("D");
            memberMapper.update(member);

            status = HttpStatus.OK;
        } else {
            status = HttpStatus.BAD_REQUEST;
        }

        return status;
    }
}
