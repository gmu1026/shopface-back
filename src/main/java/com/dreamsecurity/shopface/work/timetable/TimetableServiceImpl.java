package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.work.schedule.Schedule;
import com.dreamsecurity.shopface.work.schedule.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TimetableServiceImpl implements TimetableService {
    private final TimetableMapper timetableMapper;
    private final ScheduleMapper scheduleMapper;

    @Override
    public boolean addTimetable(Timetable timetable, Schedule schedule) {
        boolean isSuccess = false;
        if (timetable.getWorkStartTime() != null
                && !"".equals(timetable.getWorkStartTime())
                && timetable.getWorkEndTime() != null
                && !"".equals(timetable.getWorkEndTime())
                && schedule.getMemberId() != null
                && !"".equals(schedule.getMemberId())) {
            List<Timetable> timetables = this.timetableMapper.selectAll(timetable);

            if (timetables.size() == 0) {
                timetableMapper.insert(timetable);

                schedule.setTimetableNo(timetableMapper.selectAll(timetable).get(0).getNo());
                schedule.setState("R");
                scheduleMapper.insert(schedule);

                isSuccess = true;
            } else if (timetables.size() == 1) {
                schedule.setTimetableNo(timetables.get(0).getNo());
                schedule.setState("R");
                scheduleMapper.insert(schedule);

                isSuccess = true;
            }
        }
        return isSuccess;
    }

    @Override
    public List<TimetableSchedule> getTimetableList(long branchNo) {
        List<TimetableSchedule> timetableSchedules = new ArrayList<>();

        if (branchNo > 0) {
            Timetable timetable = new Timetable();
            timetable.setBranchNo(branchNo);
            List<Timetable> timetables = this.timetableMapper.selectAll(timetable);
            if (timetables.size() > 0) {
                for (int i = 0; i < timetables.size(); i++) {
                    List<Schedule> schedules = this.scheduleMapper.selectAll(Schedule
                            .builder()
                            .timetableNo(timetables.get(i).getNo())
                            .branchNo(branchNo)
                            .build());
                    for (int j = 0; j < schedules.size(); j++) {

                        timetableSchedules.add(new TimetableSchedule(timetables.get(i), schedules.get(j)));
                    }
                }
                return timetableSchedules;
            } else {
                return timetableSchedules;
            }
        } else {
            return timetableSchedules;
        }
    }

    @Override
    public boolean editTimetable(Timetable timetable, Schedule schedule) {
        LocalDateTime current = LocalDateTime.now();
        LocalDateTime startTime = timetable.getWorkStartTime();

        if (startTime.isAfter(current)) {//starttime > current
            Schedule stateCheck = this.scheduleMapper.select(schedule);

            if ("R".equals(stateCheck.getState()) || "L".equals(stateCheck.getState())) {
                Schedule select = new Schedule();
                select.setTimetableNo(schedule.getTimetableNo());
                List<Schedule> schedules = this.scheduleMapper.selectAll(select);

                if (schedules != null && schedules.size() == 1) {
                    this.timetableMapper.update(timetable);
                    return true;
                } else if (schedules != null && schedules.size() > 1) {
                    this.timetableMapper.insert(timetable);

                    List<Timetable> result = this.timetableMapper.selectAll(timetable);
                    if (result != null && result.size() == 1) {

                        schedule.setTimetableNo(result.get(0).getNo());
                        this.scheduleMapper.update(schedule);
                        return true;
                    }
                    return false;
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override
    public boolean removeTimetable(Schedule schedule) {
        if (schedule.getNo() > 0
                && schedule.getNo() > 0) {
            List<Schedule> schedules = new ArrayList<Schedule>();
            schedules = this.scheduleMapper.selectAll(schedule);
            if (schedules != null) {
                if (schedules != null && schedules.size() == 1) {
                    if ("R".equals(schedules.get(0).getState()) || "B".equals(schedules.get(0).getState())) {
                        this.scheduleMapper.delete(schedule);
                        Schedule parameter = new Schedule();
                        parameter.setTimetableNo(schedule.getNo());

                        List<Schedule> resultSchedules = this.scheduleMapper.selectAll(parameter);
                        if (resultSchedules != null) {
                            if (resultSchedules.size() > 0) {
                                return true;
                            }
                        } else {
                            this.timetableMapper.delete(Timetable.builder().no(schedule.getNo()).build());
                            return true;
                        }
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return false;
    }
}
