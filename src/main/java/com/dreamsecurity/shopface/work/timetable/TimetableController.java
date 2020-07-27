package com.dreamsecurity.shopface.work.timetable;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TimetableController {
    private TimetableService timetableService;

    @GetMapping(value = "/timetable")
    public ResponseEntity listTimetable() {
        return null;
    }

    @GetMapping(value = "/timetable/{no}")
    public ResponseEntity getTimetable() {
        return null;
    }

    @PostMapping(value = "/timetable")
    public ResponseEntity addTimetable() {
        return null;
    }

    @PutMapping(value = "/timetable/{no}")
    public ResponseEntity updateTimetable() {
        return null;
    }

    @DeleteMapping(value = "/timetable/{no}")
    public ResponseEntity removeTimetable() {
        return null;
    }
}
