package org.example.service;

import org.springframework.stereotype.Service;

@Service
public class NotificationDeleteService extends NotificationService {
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(id);
    }
}