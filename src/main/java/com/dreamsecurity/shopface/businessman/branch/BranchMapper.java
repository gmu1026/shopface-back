package com.dreamsecurity.shopface.businessman.branch;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BranchMapper {
    public void insert(Branch branch);
    public List<Branch> selectAll(Branch branch);
    public Branch select(int no);
    public void update(Branch branch);
    public void delete(Branch branch);
}
