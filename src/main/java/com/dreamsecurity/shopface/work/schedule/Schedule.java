package com.dreamsecurity.shopface.work.schedule;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias(value = "schedule")
@ToString
public class Schedule {
    private static final long serialVersionUID = 1L;
    private int no;
    private int timetableNo;
    private String name;
    private String memberId;
    private char state;
    private int branchNo;
}
