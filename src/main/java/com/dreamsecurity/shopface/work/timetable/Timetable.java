package com.dreamsecurity.shopface.work.timetable;

import lombok.*;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@Alias(value = "timetable")
public class Timetable {
    @NonNull
    private int timetableNo;
    private int branchNo;
    private String workStartTime;
    private String workEndTime;
    private String occupName;
    private String occupColor;
    private String RegisterDate;
}