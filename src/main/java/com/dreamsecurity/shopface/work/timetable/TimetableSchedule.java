package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class TimetableSchedule {
    private Timetable timetable;
    private Schedule schedule;

    public TimetableSchedule(Timetable timetable, Schedule schedule) {
        this.timetable = timetable;
        this.schedule = schedule;
    }
}
