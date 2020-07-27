package com.dreamsecurity.shopface.record;

import com.dreamsecurity.shopface.branch.Branch;
import com.dreamsecurity.shopface.branch.BranchMapper;
import com.dreamsecurity.shopface.employ.EmployMapper;
import com.dreamsecurity.shopface.work.schedule.Schedule;
import com.dreamsecurity.shopface.work.schedule.ScheduleMapper;
import com.dreamsecurity.shopface.work.timetable.TimetableMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {
    private final RecordMapper recordMapper;
    private final ScheduleMapper scheduleMapper;
    private final TimetableMapper timetableMapper;
    private final BranchMapper branchMapper;
    private final EmployMapper employMapper;
//    private final MemberMapper memberMapper;

    @Override
    public List<Record> getRecordList(Record record, Branch branch) {
        if (!"".equals(record.getMemberId())) {
            return recordMapper.selectAll(record);
        } else {
            return null;
        }
    }

    @Override
    public boolean addRecord(Schedule schedule) {
//        boolean isSuccess = false;
//
//        Schedule existSchedule = scheduleMapper.select(schedule);
//        if (existSchedule != null) {
//            Record record = new Record();
//
//            existSchedule.setState('P');
//            scheduleMapper.update(existSchedule);
//
//            Member member = new Member();
//            member.setId(existSchedule.getMemberId());
//            Member existMember = memberMapper.select(member);
//            record.setMemberName(existMember.getName());
//            record.setMemberId(existMember.getId());
//            record.setMemberPhone(existMember.getPhone());
//
//            Timetable existTimetable = timetableMapper.select(existSchedule.getTimetableNo());
//            record.setOccupationName(existTimetable.getOccupName());
//            record.setWorkStartTime(existTimetable.getWorkStartTime());
//            record.setWorkEndTime(existTimetable.getWorkEndTime());
//
//            Branch existBranch = branchMapper.select(existTimetable.getBranchNo());
//            record.setBranchNo(existBranch.getNo());
//            record.setBranchName(existBranch.getName());
//            record.setBranchPhone(existBranch.getPhone());
//
//            Member businessman = new Member();
//            businessman.setId(existBranch.getMemberId());
//            Member existBusinessman = memberMapper.select(businessman);
//            record.setBusinessmanId(existBusinessman.getId());
//            record.setBusinessmanName(existBusinessman.getName());
//
//            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//            long workStart = 0;
//            long workEnd = 0;
//            try {
//                workStart = (simpleDateFormat.parse(existTimetable.getWorkStartTime()).getTime()) / 1000;
//                workEnd = (simpleDateFormat.parse(existTimetable.getWorkEndTime()).getTime()) / 1000;
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//
//            double hours = (workEnd - workStart) / (double) 3600;
//
//            Employ employ = new Employ();
//            employ.setBranchNo(existBranch.getNo());
//            employ.setMemberId(existMember.getId());
//            Employ existEmploy = employMapper.selectEmploy(employ);
//            record.setSalaryPlan((int)(existEmploy.getSalary() * hours));
//
//            recordMapper.insert(record);
//
//            Date now = new Date();
//            if (now.compareTo(new Date(workStart)) > -1) {
//                existSchedule.setState('P');
//            } else {
//                existSchedule.setState('L');
//            }
//
//            scheduleMapper.update(existSchedule);
//
//            isSuccess = true;
//        }
//
        return false;
    }

    @Override
    public boolean editRecord(Record record) {
        boolean isSuccess = false;

        if (recordMapper.select(record) != null) {
            recordMapper.update(record);

            isSuccess = true;
        }

        return isSuccess;
    }

    @Override
    public boolean removeRecord(Record record) {
        boolean isSuccess = false;

        if (recordMapper.select(record) != null) {
            recordMapper.delete(record);

            isSuccess = true;
        }

        return isSuccess;
    }
}
