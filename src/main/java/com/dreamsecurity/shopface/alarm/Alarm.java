package com.dreamsecurity.shopface.alarm;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Alias(value = "alarm")
public class Alarm {
    private int no;
    private String addresseeId;
    private String type;
    private String contents;
    private LocalDate registerDate;
    private char checkState;

    @Builder
    public Alarm(int no, String addresseeId, String type, String contents, LocalDate registerDate, char checkState) {
        this.no = no;
        this.addresseeId = addresseeId;
        this.type = type;
        this.contents = contents;
        this.registerDate = registerDate;
        this.checkState = checkState;
    }
}
