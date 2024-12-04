package com.example.service.impl;

import com.example.entity.Feedback;
import com.example.mapper.FeedbackMapper;
import com.example.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private FeedbackMapper feedbackMapper;

    @Override
    public List<Feedback> getAllFeedbacks() {
        return feedbackMapper.selectAll();
    }

    @Override
    public List<Feedback> getFeedbacksByStatus(String status) {
        return feedbackMapper.selectByStatus(status);
    }

    @Override
    public Feedback getFeedbackById(Long feedbackid) {
        return feedbackMapper.selectById(feedbackid);
    }

    @Override
    public boolean updateFeedbackStatus(Long feedbackid, String status) {
        return feedbackMapper.updateStatus(feedbackid, status) > 0;
    }

    @Override
    public boolean deleteFeedback(Long feedbackid) {
        return feedbackMapper.deleteById(feedbackid) > 0;
    }

    @Override
    public boolean addFeedback(Feedback feedback) {
        return feedbackMapper.insert(feedback) > 0;
    }
}