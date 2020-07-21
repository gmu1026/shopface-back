package com.dreamsecurity.shopface.alarm;


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
}
