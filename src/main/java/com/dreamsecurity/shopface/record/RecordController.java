package com.dreamsecurity.shopface.record;

import com.dreamsecurity.shopface.Message;
import com.dreamsecurity.shopface.branch.Branch;
import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RecordController {
    private final RecordService recordService;

    @GetMapping(value = "/record")
    public ResponseEntity listRecord(Record record, Branch branch) {
        return new ResponseEntity<Message>(new Message()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(recordService.getRecordList(record, branch))
                .build(), HttpStatus.OK);
    }

    @GetMapping(value = "/record/{no}")
    public ResponseEntity getRecord() {
        return null;
    }

    @PostMapping(value = "/record")
    public ResponseEntity addRecord(@RequestBody Schedule schedule) {
        recordService.addRecord(schedule);

        return null;
    }

    @PutMapping(value = "/record/{no}")
    public ResponseEntity updateRecord() {
        return null;
    }

    @DeleteMapping(value = "/record/{no}")
    public ResponseEntity removeRecord() {
        return null;
    }
}
