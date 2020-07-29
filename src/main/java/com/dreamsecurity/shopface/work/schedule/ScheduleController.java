package com.dreamsecurity.shopface.work.schedule;

import com.dreamsecurity.shopface.Message;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping(value = "/schedule/{memberId}")
    public ResponseEntity listSchedule(@PathVariable String memberId) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.scheduleService.getInfo(Schedule
                        .builder()
                        .memberId(memberId)
                        .build()))
                .build(), HttpStatus.OK);
    }

//    @GetMapping(value = "/schedule/{no}")
//    public ResponseEntity getSchedule() {
//        return null;
//    }
//
//    @PostMapping(value = "/schedule")
//    public ResponseEntity addSchedule() {
//        return null;
//    }
//
//    @PutMapping(value = "/schedule/{no}")
//    public ResponseEntity updateSchedule() {
//        return null;
//    }
//
//    @DeleteMapping(value = "/schedule/{no}")
//    public ResponseEntity removeSchedule() {
//        return null;
//    }
}
