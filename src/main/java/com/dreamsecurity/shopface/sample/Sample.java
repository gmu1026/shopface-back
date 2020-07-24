package com.dreamsecurity.shopface.sample;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Sample {
    private int no;
    private String note;

    @Builder
    public Sample(int no, String note) {
        this.no = no;
        this.note = note;
    }
}
