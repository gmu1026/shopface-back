package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.Message;
import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;

@RequiredArgsConstructor
@Slf4j
@RestController
public class TimetableController {
    private final TimetableService timetableService;

    @GetMapping(value = "/timetable/{branchNo}")
    public ResponseEntity<Message> listTimetable(@PathVariable long branchNo) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(this.timetableService.getTimetableList(branchNo))
                .build(), HttpStatus.OK);
    }

//    @GetMapping(value = "/timetable/{no}")
//    public ResponseEntity getTimetable() {
//        return null;
//    }

    @PostMapping(value = "/timetable")
    public ResponseEntity<Message> addTimetable(@RequestBody TimetableSchedule timetableSchedule) {
        Timetable timetable = timetableSchedule.getTimetable();
        Schedule schedule = timetableSchedule.getSchedule();
        log.info(timetable.toString());
        log.info(schedule.toString());
        if (this.timetableService.addTimetable(timetable, schedule)) {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.OK.toString())
                    .message("Success")
                    .data(null)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("FFail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/timetable/{no}")
    public ResponseEntity<Message> updateTimetable(@PathVariable long no, @RequestBody TimetableSchedule timetableSchedule) {
        Timetable timetable = timetableSchedule.getTimetable();
        timetable.setTimetableNo(no);
        Schedule schedule = timetableSchedule.getSchedule();
        if (this.timetableService.editTimetable(timetable, schedule)) {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.OK.toString())
                    .message("Success")
                    .data(null)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Fail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/timetable/{no}")
    public ResponseEntity removeTimetable(@PathVariable long no) {
        Schedule schedule = new Schedule();
        schedule.setNo(no);
        if (this.timetableService.removeTimetable(schedule)) {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.OK.toString())
                    .message("Success")
                    .data(null)
                    .build(), HttpStatus.OK);
        } else {
            return new ResponseEntity<Message>(new Message()
                    .builder()
                    .status(HttpStatus.INTERNAL_SERVER_ERROR.toString())
                    .message("Fail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
