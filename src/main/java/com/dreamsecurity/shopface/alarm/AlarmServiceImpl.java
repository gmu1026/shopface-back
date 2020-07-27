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
        alarmMapper.insert(alarm);
        return true;
    }

    @Override
    public List<Alarm> getAlarmList(Alarm alarm) {
        return alarmMapper.selectAll(alarm);
    }

    @Override
    public boolean updateAlarm(Alarm alarm) {
        boolean isSuccess = false;

        Alarm existAlarm = alarmMapper.select(alarm);
        if (existAlarm != null) {
            alarmMapper.update(alarm);

            isSuccess = true;
        }

        return isSuccess;
    }

    @Override
    public boolean removeAlarm(Alarm alarm) {

        boolean isSuccess = false;

        Alarm existAlarm = alarmMapper.select(alarm);
        if (existAlarm != null) {
            alarmMapper.delete(alarm);

            isSuccess = true;
        }

        return isSuccess;
    }
}
