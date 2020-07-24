package com.dreamsecurity.shopface.work.schedule;

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
}
