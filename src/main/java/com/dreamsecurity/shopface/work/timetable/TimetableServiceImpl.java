package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TimetableServiceImpl implements TimetableService {
    private final TimetableMapper timetableMapper;

    @Override
    public boolean addTimetable(Timetable timetable, Schedule schedule) {
        return false;
    }

    @Override
    public List<TimetableSchedule> getTimetableList(int branchNo) {
        return null;
    }

    @Override
    public boolean editTimetable(Timetable timetable, Schedule schedule) {
        return false;
    }

    @Override
    public boolean removeTimetable(Schedule schedule) {
        return false;
    }
}
