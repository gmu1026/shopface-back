package com.dreamsecurity.shopface.work.timetable;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimetableMapper {
    Timetable select(Timetable timetable);
    List<Timetable> selectAll(Timetable timetable);
    void insert(Timetable timetable);
    void update(Timetable timetable);
    void delete(Timetable timetable);
}
