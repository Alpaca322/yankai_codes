package com.example.mapper;

import com.example.entity.DataRecords;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DataRecordsMapper {

    @Select("select * from DataRecords where RecordId = #{id}")
    DataRecords getById(Long id);
}