package com.example.mapper;

import com.example.entity.Report;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ReportMapper {

    @Select("SELECT * FROM Reports")
    List<Report> getAllReports();

    @Insert("INSERT INTO Reports(reportType, content, createdAt) VALUES(#{reportType}, #{content}, #{createdAt})")
    @Options(useGeneratedKeys = true, keyProperty = "reportId")
    int insertReport(Report report);

    @Update("UPDATE Reports SET content=#{content} WHERE reportId=#{reportId}")
    int updateReport(Report report);

    @Delete("DELETE FROM Reports WHERE reportID=#{reportId}")
    int deleteReport(Long reportId);

    @Select("SELECT * FROM Reports WHERE reportID=#{reportId}")
    Report getReportById(Integer id);
}
