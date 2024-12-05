package com.example.service;

import com.example.entity.TrafficViolation;
import com.example.utils.Result;

public interface TrafficViolationService {
    Result getViolations();
    Result getViolationById(Long violationID);
    Result addViolation(TrafficViolation violation);
    Result updateViolation(TrafficViolation violation);
    Result deleteViolation(Long violationID);
    Result queryViolations(String plateNumber, String violationType, String status);
}