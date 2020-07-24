package com.dreamsecurity.shopface.branch.occupation;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class OccupationController {
    private final OccupationService occupationService;
}
