package com.example.mapper;

import com.example.entity.TrafficViolation;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TrafficViolationMapper {
    List<TrafficViolation> getViolations();
    TrafficViolation getViolationById(Long violationID);
    void addViolation(TrafficViolation violation);
    void updateViolation(TrafficViolation violation);
    void deleteViolation(Long violationID);
    List<TrafficViolation> queryViolations(TrafficViolation query);
}