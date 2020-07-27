package com.dreamsecurity.shopface.work.timetable;

import lombok.Builder;
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

    @Builder
    public Timetable(long no, long branchNo, LocalDateTime workStartTime, LocalDateTime workEndTime, String occupationName, String occupationColor, LocalDateTime registerDate) {
        this.no = no;
        this.branchNo = branchNo;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.occupationName = occupationName;
        this.occupationColor = occupationColor;
        this.registerDate = registerDate;
    }
}
