package com.example.service.impl;

import com.example.entity.DataRecords;
import com.example.exception.BaseException;
import com.example.mapper.DataRecordsMapper;
import com.example.service.DataRecordsService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class DataRecordsServiceImpl implements DataRecordsService {

    @Autowired
    private DataRecordsMapper dataRecordsMapper;


    public DataRecords getById(Long id){
//        throw new BaseException("test exception");    抛异常

        DataRecords dataRecords = dataRecordsMapper.getById(id);
        if (dataRecords == null){
            log.info("查询失败");
            throw  new BaseException("查询失败");
        }
        return dataRecords;
    }
}
