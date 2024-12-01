package org.example.service;

import org.example.model.Notification;
import org.springframework.stereotype.Service;

@Service
public class NotificationUpdateService extends NotificationService {
    public Notification updateNotification(Long id, Notification notification) {
        notification.setNotificationId(id);  // 使用正确的 setter 方法
        return notificationRepository.save(notification);
    }
}