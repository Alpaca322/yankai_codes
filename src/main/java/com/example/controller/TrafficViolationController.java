package com.example.controller;

import com.example.entity.TrafficViolation;
import com.example.service.TrafficViolationService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/violation")
public class TrafficViolationController {

    @Autowired
    private TrafficViolationService violationService;

    @GetMapping
    public Result getViolations() {
        return violationService.getViolations();
    }

    @GetMapping("/{id}")
    public Result getViolationById(@PathVariable Long id) {
        return violationService.getViolationById(id);
    }

    @PostMapping
    public Result addViolation(@RequestBody TrafficViolation violation) {
        return violationService.addViolation(violation);
    }

    @PutMapping
    public Result updateViolation(@RequestBody TrafficViolation violation) {
        return violationService.updateViolation(violation);
    }

    @DeleteMapping("/{id}")
    public Result deleteViolation(@PathVariable Long id) {
        return violationService.deleteViolation(id);
    }

    @GetMapping("/query")
    public Result query(
            @RequestParam(required = false) String plateNumber,
            @RequestParam(required = false) String violationType,
            @RequestParam(required = false) String status
    ) {
        return violationService.queryViolations(plateNumber, violationType, status);
    }
}