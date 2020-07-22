package com.dreamsecurity.shopface.member;

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
    public ResponseEntity addMember(Member member, String certiCode, RedirectAttributes redirectAttributes) {
        HttpStatus result = memberService.addMember(member, certiCode);

        return new ResponseEntity(result);
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
    public ResponseEntity<List<Member>> getMemberList(Member member) {
        HttpStatus result = HttpStatus.OK;

        List<Member> members = memberService.getMemberList(member);
        if (members == null) {
            result = HttpStatus.BAD_REQUEST;
        } else {
            result = HttpStatus.OK;
        }

        return new ResponseEntity<>(members, result);
    }

    //회원 1개 조회 필요
    @GetMapping("/member/{id}")
    public ResponseEntity<Member> getMember(@PathVariable String id) {
        HttpStatus result = HttpStatus.OK;
        Member member = memberService.getMember(Member.builder()
                                                        .id(id)
                                                        .build());
        if (member != null) {
            result = HttpStatus.OK;
        } else {
            result = HttpStatus.NOT_FOUND;
        }
        return new ResponseEntity<>(member, result);
    }

    //회원 수정 필요
    @PutMapping("/member/{id}")
    public ResponseEntity updateMember(@PathVariable String id, Member member, String oldPassword,
                                     RedirectAttributes redirectAttributes) {
        return new ResponseEntity(memberService.editMember(member, oldPassword));
    }

    //회원 삭제 필요
    @DeleteMapping("/member/{id}")
    public ResponseEntity removeMember(@PathVariable String id) {
        return new ResponseEntity(memberService.removeMember(Member.builder()
                                                                    .id(id)
                                                                    .build()));
    }
}
