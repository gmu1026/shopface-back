package com.dreamsecurity.shopface.work.schedule;

import com.dreamsecurity.shopface.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper scheduleMapper;

    @Override
    public ResponseEntity<Message> getInfo(Schedule schedule) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.scheduleMapper.selectView(schedule))
                .build(), HttpStatus.OK);
    }
}
