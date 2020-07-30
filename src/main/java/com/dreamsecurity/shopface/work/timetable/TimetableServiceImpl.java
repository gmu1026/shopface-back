package com.dreamsecurity.shopface.work.timetable;

import com.dreamsecurity.shopface.work.schedule.Schedule;
import com.dreamsecurity.shopface.work.schedule.ScheduleMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TimetableServiceImpl implements TimetableService {
    private final TimetableMapper timetableMapper;
    private final ScheduleMapper scheduleMapper;

    @Override
    public boolean addTimetable(Timetable timetable, Schedule schedule) {
        boolean isSuccess = false;
        try {
            if (timetable.getWorkStartTime() != null
                    && timetable.getWorkStartTime() != null
                    && timetable.getWorkEndTime() != null
                    && timetable.getWorkStartTime() != null
                    && schedule.getMemberId() != null
                    && !"".equals(schedule.getMemberId())) {
                List<Timetable> timetables = this.timetableMapper.selectAll(timetable);

                log.info("" + timetableMapper.selectAll(timetable).get(0).toString());
                log.info("" + timetables.size());
                if (timetables.size() == 0) {
                    timetableMapper.insert(timetable);


                    schedule.setTimetableNo(timetableMapper.selectAll(timetable).get(0).getTimetableNo());
                    schedule.setState("R");
                    scheduleMapper.insert(schedule);

                    isSuccess = true;
                } else if (timetables.size() == 1) {
                    schedule.setTimetableNo(timetables.get(0).getTimetableNo());
                    schedule.setState("R");
                    scheduleMapper.insert(schedule);

                    isSuccess = true;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
            isSuccess = false;
        } finally {
            return isSuccess;
        }
    }

    @Override
    public List<TimetableSchedule> getTimetableList(long branchNo) {
        List<TimetableSchedule> timetableSchedules = new ArrayList<TimetableSchedule>();

        try {
            if (branchNo > 0) {
                List<Timetable> timetables = this.timetableMapper.selectAll(Timetable.builder().branchNo(branchNo).build());
                if (timetables.size() > 0) {
                    for (int i = 0; i < timetables.size(); i++) {
                        List<Schedule> schedules = this.scheduleMapper.selectAll(Schedule
                                .builder()
                                .timetableNo(timetables.get(i).getTimetableNo())
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
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean editTimetable(Timetable timetable, Schedule schedule) {
        Date current = new Date(Calendar.getInstance().getTime().getTime());
        Date startTime = timetable.getWorkStartTime();

        if (startTime.before(current)) {//starttime > current
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

                        schedule.setTimetableNo(result.get(0).getTimetableNo());
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
        List<Schedule> schedules = this.scheduleMapper.selectAll(schedule);
        if (schedules.size() > 0) {
            if ("R".equals(schedules.get(0).getState()) || "B".equals(schedules.get(0).getState())) {
                this.scheduleMapper.delete(schedule);

                return true;
            } else {
                this.timetableMapper.delete(Timetable.builder().timetableNo(schedule.getNo()).build());
                return true;
            }
        }
        return false;
    }
}
