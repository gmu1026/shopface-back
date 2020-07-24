package com.dreamsecurity.shopface.sample;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class SampleApiController {
    private final SampleApiService sampleApiService;

    @GetMapping("/sample/{no}")
    public ResponseEntity<SampleMessage> getSample(@PathVariable Long no) {
        return new ResponseEntity<SampleMessage>(new SampleMessage()
                .builder()
                .status(HttpStatus.OK.toString())
                .message("Success")
                .data(sampleApiService.getSample(no))
                .build(), HttpStatus.OK);
    }
}
