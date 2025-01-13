package com.example.dto;

import io.swagger.models.auth.In;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TrafficFlowDTO {
    LocalDate startTime;
    LocalDate endTime;
    String location;
    Integer flow;
}
