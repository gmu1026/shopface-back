package com.dreamsecurity.shopface.Member;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MemberMapper {
    void insert(Member member);
    List<Member> selectAll(Member member);
    Member select(Member member);
    void update(Member member);
    void delete(Member member);
    int countMember(Member member);
}
