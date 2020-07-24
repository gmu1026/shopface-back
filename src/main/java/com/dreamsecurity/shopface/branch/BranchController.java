package com.dreamsecurity.shopface.branch;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BranchController {
    private final BranchService branchService;
}
