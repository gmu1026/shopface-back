package com.dreamsecurity.shopface.employ;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class EmployController {
    private final EmployService employService;
}
