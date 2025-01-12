package com.example.entity;

import io.swagger.models.auth.In;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TrafficFlow {
    Integer FlowID;
    LocalDateTime Timestamp;
    Integer VehicleCount;
    String Location;
    String Anomalies;
}
