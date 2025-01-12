package com.example.controller;
import com.example.entity.Notification;
import com.example.service.NotificationService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notification")
@Api(tags = "通知模块")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/list")
    @ApiOperation(value = "获取通知列表")
    public Result<List<Notification>> getNotificationList() {
        return Result.success(notificationService.findAll());
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取通知详情")
    public Result<Notification> getNotification(@PathVariable Long id) {
        return Result.success(notificationService.findById(id));
    }

    @PostMapping
    @ApiOperation(value = "创建通知")
    public Result<Integer> createNotification(@RequestBody Notification notification) {
        return Result.success(notificationService.insert(notification));
    }

    @PutMapping
    @ApiOperation(value = "更新通知")
    public Result<Integer> updateNotification(@RequestBody Notification notification) {
        return Result.success(notificationService.update(notification));
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除通知")
    public Result<Integer> deleteNotification(@PathVariable Long id) {
        return Result.success(notificationService.deleteById(id));
    }
}