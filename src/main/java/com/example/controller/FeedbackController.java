package com.example.controller;

import com.example.entity.Feedback;
import com.example.service.FeedbackService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
@Api(tags = "反馈模块")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @GetMapping("/list")
    @ApiOperation(value = "获取反馈列表")
    public Result<List<Feedback>> getFeedbackList(@RequestParam(required = false) String status) {
        List<Feedback> list;
        if (status != null && !status.isEmpty()) {
            list = feedbackService.getFeedbacksByStatus(status);
        } else {
            list = feedbackService.getAllFeedbacks();
        }
        return Result.success(list);
    }

    @GetMapping("/detail/{id}")
    @ApiOperation(value = "获取反馈详情")
    public Result<Feedback> getFeedbackDetail(@PathVariable("id") Long feedbackid) {
        Feedback feedback = feedbackService.getFeedbackById(feedbackid);
        if (feedback != null) {
            return Result.success(feedback);
        }
        return Result.error("反馈不存在");
    }

    @PostMapping("/update")
    @ApiOperation(value = "更新反馈状态")
    public Result<String> updateFeedback(@RequestParam Long feedbackid, @RequestParam String status) {
        boolean success = feedbackService.updateFeedbackStatus(feedbackid, status);
        if (success) {
            return Result.success();
        }
        return Result.error("更新失败");
    }

    @DeleteMapping("/delete/{feedbackid}")
    @ApiOperation(value = "删除反馈")
    public Result<String> deleteFeedback(@PathVariable Long feedbackid) {
        boolean success = feedbackService.deleteFeedback(feedbackid);
        if (success) {
            return Result.success();
        }
        return Result.error("删除失败");
    }

    @PostMapping("/add")
    @ApiOperation(value = "添加反馈")
    public Result<String> addFeedback(@RequestBody Feedback feedback) {
        boolean success = feedbackService.addFeedback(feedback);
        if (success) {
            return Result.success();
        }
        return Result.error("添加失败");
    }
}