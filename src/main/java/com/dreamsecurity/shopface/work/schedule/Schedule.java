package com.dreamsecurity.shopface.work.schedule;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("Schedule")
public class Schedule {
    private long no;
    private long timetableNo;
    private String memberId;
    private String state;
    private long branchNo;

    @Builder
    public Schedule(long no, long timetableNo, String memberId, String state, long branchNo) {
        this.no = no;
        this.timetableNo = timetableNo;
        this.memberId = memberId;
        this.state = state;
        this.branchNo = branchNo;
    }
}
