package com.dreamsecurity.shopface.alarm;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class AlarmController {
    private final AlarmService alarmService;
}
