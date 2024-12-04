package com.example.entity;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
public class Feedback {
    Long feedbackid;
    Long userid;
    String status;
    String feedback_text;
    LocalDate create_time;
    LocalDate update_time;

} 