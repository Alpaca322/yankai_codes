package com.example.service.impl;

import com.example.entity.Report;
import com.example.service.ReportService;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.entity.Report;
import com.example.mapper.ReportMapper;
import com.example.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public List<Report> getAllReports() {
        return reportMapper.getAllReports();
    }

    @Override
    public boolean addReport(Report report) {
        return reportMapper.insertReport(report) > 0;
    }

    @Override
    public boolean updateReport(Report report) {
        return reportMapper.updateReport(report) > 0;
    }

    @Override
    public boolean deleteReport(Long reportId) {
        return reportMapper.deleteReport(reportId) > 0;
    }

    @Override
    public Report getReportById(Integer id) {
        return reportMapper.getReportById(id);
    }
}
