package com.dreamsecurity.shopface.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class SampleMessage {
    private String status;
    private String message;
    private Sample data;

    @Builder
    public SampleMessage (String status, String message, Sample data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }
}
