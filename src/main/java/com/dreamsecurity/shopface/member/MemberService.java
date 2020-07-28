package com.dreamsecurity.shopface.member;

import java.util.List;

public interface MemberService {
    public boolean addMember(Member member, String certiCode);
    public boolean checkIdDuplicate(String id);
    public List<Member> getMemberList(Member member);
    public Member getMember(Member member);
    public boolean editMember(Member member, String oldPassword);
    public boolean removeMember(Member member);
}
