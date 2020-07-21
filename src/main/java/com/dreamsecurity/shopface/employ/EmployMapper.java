package com.dreamsecurity.shopface.employ;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployMapper {
    public List<Employ> selectAll(Employ employ);
    public Employ select(Employ employ);
    public Employ selectEmploy(Employ employ);
    public void insert(Employ employ);
    public void update(Employ employ);
    public void delete(Employ employ);
    public int findByCertiCode(Employ employ);
}
