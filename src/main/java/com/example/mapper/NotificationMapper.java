package com.example.mapper;

import com.example.entity.Notification;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface NotificationMapper {
    List<Notification> findAll();

    Notification findById(Long id);

    int insert(Notification notification);

    int update(Notification notification);

    int deleteById(Long id);

    List<Notification> findActiveNotifications();
}