package com.dreamsecurity.shopface.member;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface MemberService {
    HttpStatus addMember(Member member, String certiCode);
    boolean checkIdDuplicate(String id);
    List<Member> getMemberList(Member member);
    Member getMember(Member member);
    HttpStatus editMember(Member member, String oldPassword);
    HttpStatus removeMember(Member member);
}
