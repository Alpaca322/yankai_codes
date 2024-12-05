package com.example.service.impl;

import com.example.entity.TrafficViolation;
import com.example.exception.BaseException;
import com.example.mapper.TrafficViolationMapper;
import com.example.service.TrafficViolationService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class TrafficViolationServiceImpl implements TrafficViolationService {

    @Autowired
    private TrafficViolationMapper violationMapper;

    @Override
    public Result getViolations() {
        List<TrafficViolation> violations = violationMapper.getViolations();
        return Result.success(violations);
    }

    @Override
    public Result getViolationById(Long violationID) {
        if (violationID == null) {
            throw new BaseException("违章ID不能为空");
        }
        TrafficViolation violation = violationMapper.getViolationById(violationID);
        return Result.success(violation);
    }

    @Override
    public Result addViolation(TrafficViolation violation) {
        if (violation.getPlateNumber() == null || violation.getPlateNumber().isEmpty()) {
            throw new BaseException("车牌号不能为空");
        }
        if (violation.getViolationType() == null || violation.getViolationType().isEmpty()) {
            throw new BaseException("违法类型不能为空");
        }

        violation.setViolationDate(LocalDateTime.now());
        violation.setStatus("Pending");
        violationMapper.addViolation(violation);
        return Result.success("添加成功");
    }

    @Override
    public Result updateViolation(TrafficViolation violation) {
        if (violation.getViolationID() == null) {
            throw new BaseException("违章ID不能为空");
        }
        violationMapper.updateViolation(violation);
        return Result.success("更新成功");
    }

    @Override
    public Result deleteViolation(Long violationID) {
        if (violationID == null) {
            throw new BaseException("违章ID不能为空");
        }
        violationMapper.deleteViolation(violationID);
        return Result.success("删除成功");
    }

    @Override
    public Result queryViolations(String plateNumber, String violationType, String status) {
        // 创建查询条件对象
        TrafficViolation query = new TrafficViolation();
        query.setPlateNumber(plateNumber);
        query.setViolationType(violationType);
        query.setStatus(status);

        // 执行查询
        List<TrafficViolation> violations = violationMapper.queryViolations(query);
        return Result.success(violations);
    }
}