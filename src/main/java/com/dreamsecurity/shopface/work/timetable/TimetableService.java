package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.work.schedule.Schedule;

import java.util.List;

public interface TimetableService {
    public boolean addTimetable(Timetable timetable, Schedule schedule);
    public List<TimetableSchedule> getTimetableList(long branchNo);
    public boolean editTimetable(Timetable timetable, Schedule schedule);
    public boolean removeTimetable(Schedule schedule);
}
