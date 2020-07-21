package com.dreamsecurity.shopface.member;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

public interface MemberService {
    boolean addMember(Member member, String certiCode);
    boolean checkIdDuplicate(String id);
    List<Member> getMemberList(Member member);
    Member getMember(Member member);
    boolean editMember(Member member, String oldPassword);
    boolean removeMember(Member member);
}
