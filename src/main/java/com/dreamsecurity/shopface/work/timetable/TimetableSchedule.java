package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class TimetableSchedule {
    private Timetable timetable;
    private Schedule schedule;
}
