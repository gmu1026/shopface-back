package com.dreamsecurity.shopface.businessman.occupation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
interface OccupationMapper {
    public void insert(Occupation Occupation);
    public List<Occupation> selectAll(Occupation occupation);
    public void update(Occupation occupation);
    public void delete(Occupation occupation);
}
