package com.dreamsecurity.shopface.member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    public void insert(Member member);
    public List<Member> selectAll(Member member);
    public Member select(Member member);
    public void update(Member member);
    public void delete(Member member);
    public int countMember(Member member);
}
