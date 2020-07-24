package com.dreamsecurity.shopface.record;

import com.dreamsecurity.shopface.branch.Branch;
import com.dreamsecurity.shopface.work.schedule.Schedule;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class RecordServiceImpl implements RecordService {
    private final RecordMapper recordMapper;

    @Override
    public List<Record> getRecordList(Record record, Branch branch) {
        return null;
    }

    @Override
    public boolean addRecord(Schedule schedule) {
        return false;
    }

    @Override
    public boolean editRecord(Record record) {
        return false;
    }

    @Override
    public boolean removeRecord(Record record) {
        return false;
    }
}
