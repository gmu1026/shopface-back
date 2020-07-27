package com.dreamsecurity.shopface.alarm;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AlarmServiceImpl implements AlarmService {
    private final AlarmMapper alarmMapper;

    @Override
    public boolean addAlarm(Alarm alarm) {
        return false;
    }

    @Override
    public List<Alarm> getAlarmList(Alarm alarm) {
        return null;
    }

    @Override
    public boolean updateAlarm(Alarm alarm) {
        return false;
    }

    @Override
    public boolean removeAlarm(Alarm alarm) {
        return false;
    }
}
