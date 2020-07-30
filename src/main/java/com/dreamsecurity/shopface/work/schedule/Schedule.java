package com.dreamsecurity.shopface.work.schedule;

import lombok.*;
import org.apache.ibatis.type.Alias;

@ToString
@Getter
@Setter
@NoArgsConstructor
@Alias("Schedule")
public class Schedule {
    private long no;
    private long timetableNo;
    private String name;
    private String memberId;
    private String state;
    private long branchNo;

    @Builder
    public Schedule(long no, long timetableNo, String name, String memberId, String state, long branchNo) {
        this.no = no;
        this.timetableNo = timetableNo;
        this.name = name;
        this.memberId = memberId;
        this.state = state;
        this.branchNo = branchNo;
    }
}
