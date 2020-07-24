package com.dreamsecurity.shopface.record;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RecordMapper {
    Record select(Record record);
    List<Record> selectAll(Record record);
    void insert(Record record);
    void update(Record record);
    void delete(Record record);
}
