package com.example.mapper;

import com.example.entity.TrafficViolation;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface TrafficViolationMapper {
    List<TrafficViolation> getViolations();
    TrafficViolation getViolationById(Long violationID);
    void addViolation(TrafficViolation violation);
    void updateViolation(TrafficViolation violation);
    void deleteViolation(Long violationID);
    List<TrafficViolation> queryViolations(TrafficViolation query);

    @Select("SELECT * FROM TrafficViolations WHERE violationDate < #{end} AND violationDate > #{begin} ORDER BY violationDate DESC")
    List<TrafficViolation> getbeginend(@Param("begin")LocalDate begin, @Param("end")LocalDate end);

    @Select("SELECT count(*) FROM TrafficViolations WHERE violationDate < #{end} AND violationDate > #{begin} AND Status = 'Processed'")
    int getbeginendFinish(@Param("begin")LocalDate begin, @Param("end")LocalDate end);
}