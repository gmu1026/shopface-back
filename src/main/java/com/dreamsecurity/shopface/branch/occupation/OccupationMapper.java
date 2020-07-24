package com.dreamsecurity.shopface.branch.occupation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OccupationMapper {
    List<Occupation> selectAll(Occupation occupation);
    void insert(Occupation occupation);
    void update(Occupation occupation);
    void delete(Occupation occupation);
}
