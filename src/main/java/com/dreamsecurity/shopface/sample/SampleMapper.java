package com.dreamsecurity.shopface.sample;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface SampleMapper {
    public Sample select(Long no);
    public List<Sample> selectAll();
}
