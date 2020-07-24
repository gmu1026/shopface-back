package com.dreamsecurity.shopface.record;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class RecordController {
    private final RecordService recordService;
}
