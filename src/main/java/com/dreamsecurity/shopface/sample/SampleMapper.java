package com.dreamsecurity.shopface.sample;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SampleMapper {
    public Sample select(Long no);
}
