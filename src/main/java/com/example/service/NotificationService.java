package com.example.service;

import com.example.entity.Notification;

import java.util.List;

public interface NotificationService {
    List<Notification> findAll();

    Notification findById(Long id);

    int insert(Notification notification);

    int update(Notification notification);

    int deleteById(Long id);

    List<Notification> findActiveNotifications();
}