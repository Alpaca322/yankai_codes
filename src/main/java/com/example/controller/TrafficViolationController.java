package com.example.controller;

import com.example.entity.TrafficViolation;
import com.example.service.TrafficViolationService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/violation")
@Api(tags = "违章模块")
public class TrafficViolationController {

    @Autowired
    private TrafficViolationService violationService;

    @GetMapping
    @ApiOperation(value = "获取违章列表")
    public Result getViolations() {
        return violationService.getViolations();
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取违章详情")
    public Result getViolationById(@PathVariable Long id) {
        return violationService.getViolationById(id);
    }

    @PostMapping
    @ApiOperation(value = "添加违章")
    public Result addViolation(@RequestBody TrafficViolation violation) {
        return violationService.addViolation(violation);
    }

    @PutMapping
    @ApiOperation(value = "更新违章")
    public Result updateViolation(@RequestBody TrafficViolation violation) {
        return violationService.updateViolation(violation);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除违章")
    public Result deleteViolation(@PathVariable Long id) {
        return violationService.deleteViolation(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询违章")
    public Result query(
            @RequestParam(required = false) String plateNumber,
            @RequestParam(required = false) String violationType,
            @RequestParam(required = false) String status
    ) {
        return violationService.queryViolations(plateNumber, violationType, status);
    }
}