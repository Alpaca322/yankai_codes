package com.example.controller;

import com.example.dto.TrafficFlowDTO;
import com.example.service.TrafficFlowService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trafficflow")
@Slf4j
@Api(tags = "交通流量模块")
public class TrafficFLowController {

    @Autowired
    private TrafficFlowService trafficFlowService;

    @PostMapping("/getflow")
    @ApiOperation(value = "获取交通流量")
    public Result getTrafficFlow(@RequestBody TrafficFlowDTO trafficFlowDTO){
        log.info("获取交通流量", trafficFlowDTO);
        return trafficFlowService.getTrafficFlow(trafficFlowDTO);
    }

    @PostMapping("/setflow")
    @ApiOperation(value = "添加交通流量")
    public Result addTrafficFlow(@RequestBody TrafficFlowDTO trafficFlowDTO){
        log.info("添加交通流量", trafficFlowDTO);
        return trafficFlowService.addTrafficFlow(trafficFlowDTO);
    }


}
