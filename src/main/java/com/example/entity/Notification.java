package com.example.entity;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Notification {
    Long notificationid;
    String notificationtype;
    String content;
    String creator;
    LocalDate create_time;
    LocalDate end_time;
}
