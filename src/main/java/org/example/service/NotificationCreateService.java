package org.example.service;

import org.example.model.Notification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class NotificationCreateService extends NotificationService {
    public Notification createNotification(Notification notification) {
        notification.setCreateTime(LocalDateTime.now()); // 设置创建时间
        return notificationRepository.save(notification);
    }
}