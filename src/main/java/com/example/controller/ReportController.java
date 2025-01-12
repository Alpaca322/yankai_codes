package com.example.controller;

import com.example.dto.TrafficFlowDTO;
import com.example.entity.TrafficViolation;
import com.example.mapper.FeedbackMapper;
import com.example.mapper.TrafficFlowMapper;
import com.example.mapper.TrafficViolationMapper;
import com.example.utils.Result;
import com.example.entity.Report;
import com.example.service.ReportService;
import io.github.classgraph.Resource;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;


@RestController
@Slf4j
@RequestMapping("/report")
@Api(tags = "报告模块")
public class ReportController {

    @Autowired
    private ReportService reportService;
    @Autowired
    private TrafficViolationMapper trafficViolationMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private TrafficFlowMapper trafficFlowMapper;

    @GetMapping("/list")
    public List<Report> getAllReports() {
        return reportService.getAllReports();
    }

    @PostMapping
    public boolean addReport(@RequestBody Report report) {
        return reportService.addReport(report);
    }

    @PutMapping("/{id}")
    public boolean updateReport(@PathVariable Integer id, @RequestBody Report report) {
        report.setReportId(id);
        return reportService.updateReport(report);
    }

    @DeleteMapping("/{id}")
    public boolean deleteReport(@PathVariable Long id) {
        return reportService.deleteReport(id);
    }

    @GetMapping("/download/{id}")
    public void downloadReport(@PathVariable Integer id, HttpServletResponse response) {
        log.info("下载报告");
        try {
            // 1. 获取报告数据
            Report report = reportService.getReportById(id);
            if (report == null) {
                return ;
            }

            int trafficFlow = 0;
            int violationCount = 0;
            String violationFinishRate = "0%";
            int feedBackCount = 0;
            String feedBackFinishRate = "0%";

            InputStream in =  this.getClass().getClassLoader().getResourceAsStream("template/报表模板.xlsx");
            try {
                XSSFWorkbook workbook = new XSSFWorkbook(in);

                // 填充时间数据
                XSSFSheet sheet = workbook.getSheet("Sheet1");
                LocalDate begin,end;
                if (report.getReportType().equals( "Daily") ){
                    begin =  LocalDate.now();
                    end = begin;
                    sheet.getRow(1).getCell(1).setCellValue("时间: " + begin.toString() );
                } else if (report.getReportType().equals("Weekly")) {
                    end = LocalDate.now();
                    begin = end.plusDays(-7);
                    sheet.getRow(1).getCell(1).setCellValue("时间: " + begin.toString() + " - " + end.toString());
                } else if (report.getReportType().equals("Monthly")) {
                    end = LocalDate.now();
                    begin = end.plusDays(-30);
                    sheet.getRow(1).getCell(1).setCellValue("时间: " + begin.toString() + " - " + end.toString());
                } else {
                    end = LocalDate.now();
                    begin = end.plusDays(-365);
                    sheet.getRow(1).getCell(1).setCellValue("时间: " + begin.toString() + " - " + end.toString());
                }


                TrafficFlowDTO trafficFlowDTO = TrafficFlowDTO
                        .builder().startTime(begin).endTime(end).build();

                trafficFlow = trafficFlowMapper.getFlow(trafficFlowDTO);

                List<TrafficViolation> lists = trafficViolationMapper.getbeginend(begin.plusDays(-1),end.plusDays(1));
                violationCount = lists.size();
                violationFinishRate = trafficViolationMapper.getbeginendFinish(begin.plusDays(-1),end.plusDays(1)) / violationCount * 100+ "%";
                feedBackCount = feedbackMapper.getFeedBackCount();
                feedBackFinishRate = feedbackMapper.getFeedBackCountFinish()/feedBackCount * 100 + "%";
                // 填充数据

                XSSFRow row = sheet.getRow(3);
                row.getCell(2).setCellValue(trafficFlow+"");  // 车流量
                row.getCell(4).setCellValue(violationCount+""); //  违法数量
                row.getCell(6).setCellValue(violationFinishRate); // 解决率

                row = sheet.getRow(4);
                row.getCell(2).setCellValue(feedBackCount);   // 反馈数量
                row.getCell(4).setCellValue(feedBackFinishRate);     // 反馈解决率

                // 循环填充响应数据


                for (int i=0; i<30; i++){
                    row = sheet.getRow(7+i);
                    if (lists.size() <= i){
                        break;
                    }

                    TrafficViolation tf = lists.get(i);
                    // 填充数据
                    row.getCell(1).setCellValue(tf.getViolationDate().toString());   // 日期
                    row.getCell(2).setCellValue(tf.getPlateNumber()); // 营业额
                    row.getCell(3).setCellValue(tf.getViolationType());  // 有效订单数
                    row.getCell(4).setCellValue(tf.getLocation()); // 订单完成率
                }



                ServletOutputStream out  =response.getOutputStream();
                workbook.write(out);
                out.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
