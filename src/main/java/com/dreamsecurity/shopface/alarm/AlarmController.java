package com.dreamsecurity.shopface.alarm;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AlarmController {
    private final AlarmService alarmService;

    @GetMapping(value = "/alarm")
    public ResponseEntity listAlarm() {
        return null;
    }

    @GetMapping(value = "/alarm/{no}")
    public ResponseEntity getAlarm() {
        return null;
    }

    @PostMapping(value = "/alarm")
    public ResponseEntity addAlarm() {
        return null;
    }

    @PutMapping(value = "/alarm/{no}")
    public ResponseEntity updateAlarm() {
        return null;
    }

    @DeleteMapping(value = "/alarm/{no}")
    public ResponseEntity removeAlarm() {
        return null;
    }
}
