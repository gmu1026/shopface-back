package com.dreamsecurity.shopface.work.schedule;

import com.dreamsecurity.shopface.Message;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ScheduleService {
    public ResponseEntity<Message> getInfo(Schedule schedule);
}
