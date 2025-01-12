package com.example.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class TrafficFlow {
    Integer FlowID;
    LocalDate Timestamp;
    Integer VehicleCount;
    String Location;
    String Anomalies;
}
