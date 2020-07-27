package com.dreamsecurity.shopface.work.schedule;

import com.dreamsecurity.shopface.branch.Branch;
import com.dreamsecurity.shopface.work.timetable.Timetable;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.ibatis.type.Alias;

@Getter
@Setter
@NoArgsConstructor
@Alias("ScheduleTimetable")
public class ScheduleTimetable {
    private Timetable timetable;
    private Schedule schedule;
    private Branch branch;
}
