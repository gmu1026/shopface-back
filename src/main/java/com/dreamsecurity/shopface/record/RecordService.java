package com.dreamsecurity.shopface.record;

import com.dreamsecurity.shopface.branch.Branch;
import com.dreamsecurity.shopface.work.schedule.Schedule;

import java.util.List;

public interface RecordService {
    public List<Record> getRecordList(Record record, Branch branch);
    public boolean addRecord(Schedule schedule);
    public boolean editRecord(Record record);
    public boolean removeRecord(Record record);
}
