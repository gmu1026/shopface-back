package com.dreamsecurity.shopface.work.schedule;

import com.dreamsecurity.shopface.Message;
import com.dreamsecurity.shopface.work.timetable.TimetableSchedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleTimetable> getInfo(Schedule schedule) {
        return scheduleMapper.selectView(schedule);
    }
}
