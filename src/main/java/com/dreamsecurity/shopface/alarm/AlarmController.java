package com.dreamsecurity.shopface.alarm;

import com.dreamsecurity.shopface.Message;
import com.dreamsecurity.shopface.sample.SampleMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class AlarmController {
    private final AlarmService alarmService;

    @GetMapping(value = "/alarm")
    public ResponseEntity<Message> listAlarm(Alarm alarm) {
       return new ResponseEntity<Message>(new Message()
               .builder()
               .status(HttpStatus.OK.toString())
               .message("Success")
               .data(alarmService.addAlarm(alarm))
               .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/alarm/{no}")
    public ResponseEntity getAlarm() {
        return null;
    }

    @PostMapping(value = "/alarm")
    public ResponseEntity addAlarm(Alarm alarm) {
        if (alarmService.addAlarm(alarm)) {
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

    @PutMapping(value = "/alarm/{no}")
    public ResponseEntity updateAlarm(Alarm alarm) {
        if (alarmService.updateAlarm(alarm)) {
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

    @DeleteMapping(value = "/alarm/{no}")
    public ResponseEntity removeAlarm(Alarm alarm) {
        if (alarmService.removeAlarm(alarm)) {
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
