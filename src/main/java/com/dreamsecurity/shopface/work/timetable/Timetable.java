package com.dreamsecurity.shopface.work.timetable;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Alias("Timetable")
public class Timetable {
    private long no;
    private long branchNo;
    private LocalDateTime workStartTime;
    private LocalDateTime workEndTime;
    private String occupationName;
    private String occupationColor;
    private LocalDateTime registerDate;
}
