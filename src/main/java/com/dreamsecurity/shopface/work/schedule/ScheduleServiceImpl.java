package com.dreamsecurity.shopface.work.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper scheduleMapper;

    @Override
    public List<ScheduleTimetable> getInfo(Schedule schedule) {
        return null;
    }
}
