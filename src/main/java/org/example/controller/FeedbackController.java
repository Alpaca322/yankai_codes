package org.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.example.service.FeedbackService;
import org.example.model.Feedback;
//@CrossOrigin(origins = "http://localhost:63342")
@RestController
@RequestMapping("/api/feedback")

public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    // 健康检查 API
    @GetMapping("/health")
    public ResponseEntity<String> checkHealth() {
        try {
            // 尝试连接数据库（可以添加实际的数据库连接验证逻辑）
            feedbackService.getAllFeedback();
            return ResponseEntity.ok("数据库连接正常");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("无法连接到数据库");
        }
    }

    @PostMapping
    public ResponseEntity<Feedback> submitFeedback(@RequestBody Feedback feedback) {
        // 如果 userid 为 null 或负值，则设置为默认值 0
        if (feedback.getUserId() == 0 || feedback.getUserId() < 0) {
            feedback.setUserId(0);
        }
        Feedback savedFeedback = feedbackService.submitFeedback(feedback);
        return ResponseEntity.ok(savedFeedback);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Feedback> updateFeedback(@PathVariable int id, @RequestBody Feedback feedback) {
        Feedback updatedFeedback = feedbackService.updateFeedback(id, feedback);
        return ResponseEntity.ok(updatedFeedback);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFeedback(@PathVariable int id) {
        feedbackService.deleteFeedback(id);
        return ResponseEntity.noContent().build();
    }
}