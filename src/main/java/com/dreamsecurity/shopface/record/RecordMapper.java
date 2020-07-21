package com.dreamsecurity.shopface.record;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    public void insert(Record record);
    public Record select(Record record);
    public List<Record> selectAll(Record record);
    public void update(Record record);
    public void delete(Record record);
    public void quittingUpadte(Record record);
}
