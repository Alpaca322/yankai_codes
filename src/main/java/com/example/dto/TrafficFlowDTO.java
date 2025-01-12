package com.example.dto;

import io.swagger.models.auth.In;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
@Data
@Builder
public class TrafficFlowDTO {
    LocalDate startTime;
    LocalDate endTime;
    String location;
    Integer flow;
}
