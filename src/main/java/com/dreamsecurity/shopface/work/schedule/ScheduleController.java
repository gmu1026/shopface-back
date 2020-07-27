package com.dreamsecurity.shopface.work.schedule;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping(value = "/schedule")
    public ResponseEntity listSchedule() {
        return null;
    }

    @GetMapping(value = "/schedule/{no}")
    public ResponseEntity getSchedule() {
        return null;
    }

    @PostMapping(value = "/schedule")
    public ResponseEntity addSchedule() {
        return null;
    }

    @PutMapping(value = "/schedule/{no}")
    public ResponseEntity updateSchedule() {
        return null;
    }

    @DeleteMapping(value = "/schedule/{no}")
    public ResponseEntity removeSchedule() {
        return null;
    }
}
