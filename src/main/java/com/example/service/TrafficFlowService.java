package com.example.service;

import com.example.dto.TrafficFlowDTO;
import com.example.utils.Result;

public interface TrafficFlowService {
    Result getTrafficFlow(TrafficFlowDTO trafficFlowDTO);
    Result addTrafficFlow(TrafficFlowDTO trafficFlowDTO);
}
