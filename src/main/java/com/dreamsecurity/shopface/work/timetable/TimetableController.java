package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.Message;
import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TimetableController {
    private TimetableService timetableService;

    @GetMapping(value = "/timetable")
    public ResponseEntity listTimetable(long branchNo) {
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
    public ResponseEntity addTimetable(Timetable timetable, Schedule schedule) {
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
                    .message("Fail")
                    .data(null)
                    .build(), HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping(value = "/timetable/{no}")
    public ResponseEntity updateTimetable(Timetable timetable, Schedule schedule) {
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
    public ResponseEntity removeTimetable(Schedule schedule) {
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
