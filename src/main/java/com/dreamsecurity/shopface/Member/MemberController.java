package com.dreamsecurity.shopface.Member;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberController {
    private final MemberService memberService;

    //회원 등록
    @PostMapping("/member")
    public String addMember(Member member, String certiCode, RedirectAttributes redirectAttributes) {

        if (memberService.addMember(member, certiCode)) {
            return "addSuccess";
        } else {
            return "addFail";
        }
    }

    //회원가입시 아이디중복확인 고려
    @GetMapping(value = "/member/check", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MemberMessage> checkId(@RequestParam("id") String id) {
        MemberMessage message = new MemberMessage();

        if (memberService.checkIdDuplicate(id)) {
            message.setDuplicate(true);
            message.setMessage("입력한 아이디가 사용 중 입니다.");
        } else {
            message.setDuplicate(false);
            message.setMessage("사용가능한 아이디입니다.");
        }

        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    //회원 목록 조회 필요
    @GetMapping(value = "/member", consumes = MediaType.APPLICATION_JSON_VALUE)
    public List<Member> getMemberList(Member member) {
        return memberService.getMemberList(member);
    }

    //회원 1개 조회 필요
    @GetMapping("/member/{id}")
    public Member getMember(@PathVariable String id) {

        Member member = new Member();
        member.setId(id);

        return memberService.getMember(member);
    }

    //회원 수정 필요
    @PutMapping("/member/{id}")
    public String updateMember(@PathVariable String id, Member member, String oldPassword,
                                     RedirectAttributes redirectAttributes) {

        boolean isSuccess = memberService.editMember(member, oldPassword);
        if(isSuccess) {
           return "updateSuccess";
        } else {
            return "updateFail";
        }
    }

    //회원 삭제 필요
    @DeleteMapping("/member/{id}")
    public String removeMember(@PathVariable String id) {
        Member member = new Member();
        member.setId(id);

        memberService.removeMember(member);

        return "";
    }
}
