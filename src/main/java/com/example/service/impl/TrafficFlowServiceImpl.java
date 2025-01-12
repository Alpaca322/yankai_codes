package com.example.service.impl;

import com.example.dto.TrafficFlowDTO;
import com.example.entity.TrafficFlow;
import com.example.exception.BaseException;
import com.example.mapper.TrafficFlowMapper;
import com.example.service.TrafficFlowService;
import com.example.utils.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class TrafficFlowServiceImpl implements TrafficFlowService {

    @Autowired
    private TrafficFlowMapper trafficFlowMapper;

    @Override
    public Result getTrafficFlow(TrafficFlowDTO trafficFlowDTO) {

        int flow = trafficFlowMapper.getFlow(trafficFlowDTO);
        return Result.success(flow);
    }

    @Override
    public Result addTrafficFlow(TrafficFlowDTO trafficFlowDTO) {
        if (trafficFlowDTO.getLocation() == null || trafficFlowDTO.getLocation().isEmpty()){
            throw new BaseException("地点不能为空");
        }
        if (trafficFlowDTO.getStartTime() == null){
            trafficFlowDTO.setStartTime(LocalDate.now());
        }
        TrafficFlow trafficFlow = trafficFlowMapper.getTF(trafficFlowDTO.getLocation(),trafficFlowDTO.getStartTime());
        if (trafficFlow != null){
            trafficFlow.setVehicleCount(trafficFlowDTO.getFlow());
            trafficFlowMapper.updateFlow(trafficFlow);
        }else {
            trafficFlow = new TrafficFlow();
            trafficFlow.setLocation(trafficFlowDTO.getLocation());
            trafficFlow.setVehicleCount(trafficFlowDTO.getFlow());
            trafficFlow.setTimestamp(trafficFlowDTO.getStartTime());
            trafficFlowMapper.addFlow(trafficFlow);
        }
        return Result.success();
    }


}
