package com.dreamsecurity.shopface.work.schedule;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    public void insert(Schedule schedule);
    public List<Schedule> selectAll(Schedule schedule);
    public List<Test> selectView(Schedule schedule);
    public Schedule select(Schedule schedule);
    public void update(Schedule schedule);
    public void delete(Schedule schedule);
}
