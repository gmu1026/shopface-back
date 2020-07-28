package com.dreamsecurity.shopface.member;

import com.dreamsecurity.shopface.Message;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Slf4j
@RestController
public class MemberController {
    private final MemberService memberService;

    @PostMapping("/member")
    public ResponseEntity<Message> addMember(Member member, String certiCode) {
        boolean isSuccess = memberService.addMember(member, certiCode);
        
        //TODO isSuccess false 시 Exception 처리
        
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("회원가입 성공")
                .data(null)
                .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/member/check")
    public ResponseEntity<Message> checkId(@RequestParam("id") String id) {
        memberService.checkIdDuplicate(id);
        // TODO 분기 추가
//        if (memberService.checkIdDuplicate(id)) {
//            message.setDuplicate(true);
//            message.setMessage("입력한 아이디가 사용 중 입니다.");
//        } else {
//            message.setDuplicate(false);
//            message.setMessage("사용가능한 아이디입니다.");
//        }

        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message(id + "의 중복체크 결과")
                .data(true)
                .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/member")
    public ResponseEntity<Message> getMemberList(Member member) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Member List")
                .data(memberService.getMemberList(member))
                .build(), HttpStatus.OK);
    }

    @GetMapping("/member/{id}")
    public ResponseEntity<Message> getMember(@PathVariable String id) {
        Member member = new Member();
        member.setId(id);

        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message(id + " 의 Detail Getting Success")
                .data(memberService.getMember(member))
                .build(), HttpStatus.OK);
    }

    @PutMapping("/member/{id}")
    public ResponseEntity<Message> updateMember(@PathVariable String id, @RequestBody Member member, String oldPassword) {
        log.info(member.getEmail());

        member.setId(id);
        boolean isSuccess = memberService.editMember(member, oldPassword);

        //TODO isSuccess false 시 Exception 처리
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message(id + "가 수정되었습니다.")
                .data(null)
                .build(), HttpStatus.OK);
    }

    @DeleteMapping("/member/{id}")
    public ResponseEntity<Message> removeMember(@PathVariable String id) {
        Member member = new Member();
        member.setId(id);

        memberService.removeMember(member);

        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message(id + "가 삭제되었습니다.")
                .data(null)
                .build(), HttpStatus.OK);
    }
}
