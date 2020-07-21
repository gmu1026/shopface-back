package com.dreamsecurity.shopface.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class MemberServiceImpl implements MemberService {
    private final MemberMapper memberMapper;
//    private final EmployMapper employMapper;
//    private final AlarmMapper alarmMapper;
//    private final BranchMapper branchMapper;

    @Transactional
    @Override
    public boolean addMember(Member member, String certiCode) {
        boolean isSuccess = false;

        if (!member.getId().equals("")
                && !member.getName().equals("")
                && !member.getPassword().equals("")
                && !member.getPhone().equals("")) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            member.setPassword(passwordEncoder.encode(member.getPassword()));
            memberMapper.insert(member);

//            if (!"".equals(certiCode)) {
//                Employ employ = new Employ();
//                employ.setCertiCode(certiCode);
//                Employ existEmploy = employMapper.select(employ);
//
//                employ.setNo(existEmploy.getNo());
//                employ.setMemberId(member.getId());
//                employ.setEmployDate(new Date(Calendar.getInstance().getTime().getTime()));
//                employ.setCertiCode(null);
//                employ.setState('C');
//                employMapper.update(employ);
//
//                Branch existBranch = branchMapper.select(existEmploy.getBranchNo());
//
//                Alarm alarm = new Alarm();
//                alarm.setAddresseeId(existBranch.getMemberId());
//                alarm.setContents(member.getName() + "- 근무자가 합류했습니다.");
//                alarm.setType("근무자 합류");
//                alarmMapper.insert(alarm);
//            }

            isSuccess = true;
        }

        return isSuccess;
    }

    @Transactional
    @Override
    public boolean checkIdDuplicate(String id) {
        boolean isDuplicate = false;

        Member member = new Member();
        member.setId(id);

        Member existMember = memberMapper.select(member);
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
    public boolean editMember(Member member, String oldPassword) {
        boolean isSuccess = false;

        Member existMember = memberMapper.select(member);
        if (existMember != null) {
            if (oldPassword == null || "".equals(oldPassword)) {
                memberMapper.update(member);

                isSuccess = true;
            }

            if (member.getPassword() != null) {
                if (existMember.getPassword().equals(oldPassword)) {
                    BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
                    member.setPassword(passwordEncoder.encode(member.getPassword()));

                    memberMapper.update(member);

                    isSuccess = true;
                } else {
                    memberMapper.update(member);

                    isSuccess = true;
                }
            }
        }

        return isSuccess;
    }

    @Transactional
    @Override
    public boolean removeMember(Member member) {
        if (member.getId() != null
                && memberMapper.select(member) != null) {
            member.setState("D");
            memberMapper.update(member);

            return true;
        } else {
            return false;
        }
    }
}
