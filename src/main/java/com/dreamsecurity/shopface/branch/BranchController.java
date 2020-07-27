package com.dreamsecurity.shopface.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class BranchController {
    private final BranchService branchService;

    @GetMapping(value = "/branch")
    public ResponseEntity listBranch() {
        return null;
    }

    @GetMapping(value = "/branch/{no}")
    public ResponseEntity getBranch() {
        return null;
    }

    @PostMapping(value = "/branch")
    public ResponseEntity addBranch() {
        return null;
    }

    @PutMapping(value = "/branch/{no}")
    public ResponseEntity updateBranch() {
        return null;
    }

    @DeleteMapping(value = "/branch/{no}")
    public ResponseEntity removeBranch() {
        return null;
    }
}
