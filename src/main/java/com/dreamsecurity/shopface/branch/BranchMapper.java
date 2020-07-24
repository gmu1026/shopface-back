package com.dreamsecurity.shopface.branch;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BranchMapper {
    Branch select(Branch branch);
    List<Branch> selectAll(Branch branch);
    void insert(Branch branch);
    void update(Branch branch);
    void delete(Branch branch);
}
