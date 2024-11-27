package com.example.controller;

import com.example.entity.DataRecords;
import com.example.service.DataRecordsService;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/datarecords")
public class DataRecordsController {

    @Autowired
    private DataRecordsService dataRecordsService;


    @GetMapping("/{id}")
    public Result getById(@PathVariable Long id){
        return Result.success(dataRecordsService.getById(id));
    }
}
