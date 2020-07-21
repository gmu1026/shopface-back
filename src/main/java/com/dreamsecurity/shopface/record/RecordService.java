package com.dreamsecurity.shopface.record;

import com.dreamsecurity.shopface.businessman.branch.Branch;
import com.dreamsecurity.shopface.work.schedule.Schedule;

import java.util.List;

public interface RecordService {
    public boolean addRecord(Schedule schedule);
    public List<Record> getRecordList(Record record, Branch branch);
    public boolean editRecord(Record record);
    public boolean removeRecord(Record record);
    public boolean qutting(Schedule schedule);
}
