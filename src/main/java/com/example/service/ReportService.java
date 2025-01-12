package com.example.service;

import com.example.entity.Report;

import java.util.List;



public interface ReportService {
    List<Report> getAllReports();
    boolean addReport(Report report);
    boolean updateReport(Report report);
    boolean deleteReport(Long reportId);

    Report getReportById(Integer id);
}