package com.example.controller;
import com.example.entity.Notification;
import com.example.service.NotificationService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/notification")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @GetMapping("/list")
    public Result<List<Notification>> getNotificationList() {
        return Result.success(notificationService.findAll());
    }

    @GetMapping("/{id}")
    public Result<Notification> getNotification(@PathVariable Long id) {
        return Result.success(notificationService.findById(id));
    }

    @PostMapping
    public Result<Integer> createNotification(@RequestBody Notification notification) {
        return Result.success(notificationService.insert(notification));
    }

    @PutMapping
    public Result<Integer> updateNotification(@RequestBody Notification notification) {
        return Result.success(notificationService.update(notification));
    }

    @DeleteMapping("/{id}")
    public Result<Integer> deleteNotification(@PathVariable Long id) {
        return Result.success(notificationService.deleteById(id));
    }
}