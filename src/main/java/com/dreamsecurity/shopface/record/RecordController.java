package com.dreamsecurity.shopface.record;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class RecordController {
    private final RecordService recordService;

    @GetMapping(value = "/record")
    public ResponseEntity listRecord() {
        return null;
    }

    @GetMapping(value = "/record/{no}")
    public ResponseEntity getRecord() {
        return null;
    }

    @PostMapping(value = "/record")
    public ResponseEntity addRecord() {
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
