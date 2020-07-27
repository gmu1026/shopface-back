package com.dreamsecurity.shopface.branch.occupation;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class OccupationController {
    private final OccupationService occupationService;

    @GetMapping(value = "/occupation")
    public ResponseEntity listOccupation() {
        return null;
    }

    @GetMapping(value = "/occupation/{no}")
    public ResponseEntity getOccupation() {
        return null;
    }

    @PostMapping(value = "/occupation")
    public ResponseEntity addOccupation() {
        return null;
    }

    @PutMapping(value = "/occupation/{no}")
    public ResponseEntity updateOccupation() {
        return null;
    }

    @DeleteMapping(value = "/occupation/{no}")
    public ResponseEntity removeOccupation() {
        return null;
    }
}
