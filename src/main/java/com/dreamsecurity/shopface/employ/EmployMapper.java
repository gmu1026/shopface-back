package com.dreamsecurity.shopface.employ;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployMapper {
    Employ select(Employ employ);
    List<Employ> selectAll(Employ employ);
    void insert(Employ employ);
    void update(Employ employ);
    void delete(Employ employ);
    int findByCertiCode(Employ employ);
}
