package com.example.controller;

import com.example.service.LogService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@Slf4j
@RequestMapping("/log")
@Api(tags = "日志模块")
public class LogController {

    @Autowired
    private LogService logService;

    @GetMapping("/list")
    @ApiOperation("获取日志列表")
    public Result getLogList() {
        log.info("获取日志列表");
        return logService.getLogList();
    }

    @GetMapping("/detail/{name}")
    @ApiOperation("获取日志详情")
    public void getLogDetail(@PathVariable String name, HttpServletResponse response) {
        log.info("获取日志详情：{}", name);
        logService.getLogDetail(name, response);
    }
}
