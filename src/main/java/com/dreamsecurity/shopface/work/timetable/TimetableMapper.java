package com.dreamsecurity.shopface.work.timetable;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TimetableMapper {
    public void insert(Timetable timetable);
    public List<Timetable> selectAll(Timetable timetable);
    public Timetable select(int no);
    public void update(Timetable timetable);
    public void delete(Timetable timetable);
}
