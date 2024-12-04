package com.example.service;

import com.example.entity.Feedback;
import java.util.List;

public interface FeedbackService {
    List<Feedback> getAllFeedbacks();

    List<Feedback> getFeedbacksByStatus(String status);

    Feedback getFeedbackById(Long feedbackid);

    boolean updateFeedbackStatus(Long feedbackid, String status);

    boolean deleteFeedback(Long feedbackid);

    boolean addFeedback(Feedback feedback);
}