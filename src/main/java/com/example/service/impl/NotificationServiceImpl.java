package com.example.service.impl;

import com.example.entity.Notification;
import com.example.mapper.NotificationMapper;
import com.example.service.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationMapper notificationMapper;

    @Override
    public List<Notification> findAll() {
        return notificationMapper.findAll();
    }

    @Override
    public Notification findById(Long id) {
        return notificationMapper.findById(id);
    }

    @Override
    public int insert(Notification notification) {
        notification.setCreate_time(LocalDate.now());
        return notificationMapper.insert(notification);
    }

    @Override
    public int update(Notification notification) {
        return notificationMapper.update(notification);
    }

    @Override
    public int deleteById(Long id) {
        return notificationMapper.deleteById(id);
    }

    @Override
    public List<Notification> findActiveNotifications() {
        return notificationMapper.findActiveNotifications();
    }
}