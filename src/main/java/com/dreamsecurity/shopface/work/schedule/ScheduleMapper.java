package com.dreamsecurity.shopface.work.schedule;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ScheduleMapper {
    List<ScheduleTimetable> selectView(Schedule schedule);
    Schedule select(Schedule schedule);
    List<Schedule> selectAll(Schedule schedule);
    void insert(Schedule schedule);
    void update(Schedule schedule);
    void delete(Schedule schedule);
}
