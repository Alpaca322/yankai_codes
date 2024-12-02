package org.example.service;

import org.example.model.Feedback;
import org.example.repository.FeedbackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

    public Feedback submitFeedback(Feedback feedback) {
        feedback.setCreateTime(LocalDateTime.now());
        feedback.setUpdateTime(LocalDateTime.now());
        return feedbackRepository.save(feedback);
    }

    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }

    public Feedback updateFeedback(int id, Feedback feedback) {
        Feedback existingFeedback = feedbackRepository.findById(id).orElseThrow(() -> new RuntimeException("Feedback not found"));
        existingFeedback.setFeedbackText(feedback.getFeedbackText());
        existingFeedback.setStatus(feedback.getStatus());
        existingFeedback.setUpdateTime(LocalDateTime.now());
        return feedbackRepository.save(existingFeedback);
    }

    public void deleteFeedback(int id) {
        feedbackRepository.deleteById(id);
    }
}