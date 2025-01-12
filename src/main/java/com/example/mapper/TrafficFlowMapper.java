package com.example.mapper;

import com.example.dto.TrafficFlowDTO;
import com.example.entity.TrafficFlow;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;

@Mapper
public interface TrafficFlowMapper {

    @Select("SELECT * FROM TrafficFlow WHERE Location = #{location} AND Timestamp = #{startTime}")
    TrafficFlow getTF(@Param("location") String location, @Param("startTime") LocalDate startTime);


    @Update("UPDATE TrafficFlow SET VehicleCount = #{VehicleCount} WHERE FlowID = #{FlowID}")
    void updateFlow(TrafficFlow trafficFlow);

    @Insert("INSERT INTO TrafficFlow (Location, VehicleCount, Timestamp) VALUES (#{Location}, #{VehicleCount}, #{Timestamp})")
    void addFlow(TrafficFlow trafficFlow);

    int getFlow(TrafficFlowDTO trafficFlowDTO);
}
