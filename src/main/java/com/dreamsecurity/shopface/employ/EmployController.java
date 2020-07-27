package com.dreamsecurity.shopface.employ;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class EmployController {
    private final EmployService employService;

    @GetMapping(value = "/employ")
    public ResponseEntity listEmploy() {
        return null;
    }

    @GetMapping(value = "/employ/{no}")
    public ResponseEntity getEmploy() {
        return null;
    }

    @PostMapping(value = "/employ")
    public ResponseEntity addEmploy() {
        return null;
    }

    @PutMapping(value = "/employ/{no}")
    public ResponseEntity updateEmploy() {
        return null;
    }

    @DeleteMapping(value = "/employ/{no}")
    public ResponseEntity removeEmploy() {
        return null;
    }
}
