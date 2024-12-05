package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class TrafficViolation {
    private Long violationID;
    private String violationType;
    private LocalDateTime violationDate;
    private String location;
    private String status;  // enum('Pending', 'Processed', 'Archive')
    private String evidence;
    private String plateNumber;
}