package com.dreamsecurity.shopface.work.timetable;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.apache.ibatis.type.Alias;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Alias("Timetable")
public class Timetable {
    private long timetableNo;
    private long branchNo;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Date workStartTime;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = "Asia/Seoul")
    private Date workEndTime;
    private String occupationName;
    private String occupationColor;
    private Date registerDate;
    private String occupName;
    private String occupColor;

    @Builder
    public Timetable(long timetableNo, long branchNo, Date workStartTime, Date workEndTime, String occupationName, String occupationColor, Date registerDate, String occupName, String occupColor) {
        this.timetableNo = timetableNo;
        this.branchNo = branchNo;
        this.workStartTime = workStartTime;
        this.workEndTime = workEndTime;
        this.occupationName = occupationName;
        this.occupationColor = occupationColor;
        this.registerDate = registerDate;
        this.occupName = occupName;
        this.occupColor = occupColor;
    }
}
