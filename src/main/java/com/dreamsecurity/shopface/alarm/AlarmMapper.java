package com.dreamsecurity.shopface.alarm;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {
    Alarm select(Alarm alarm);
    List<Alarm> selectAll(Alarm alarm);
    void insert(Alarm alarm);
    void update(Alarm alarm);
    void delete(Alarm alarm);
}
