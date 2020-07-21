package com.dreamsecurity.shopface.alarm;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AlarmMapper {
    public List<Alarm> selectAll(Alarm alarm);
    public Alarm select(Alarm alarm);
    public void insert(Alarm alarm);
    public void update(Alarm alarm);
    public void delete(Alarm alarm);
}
