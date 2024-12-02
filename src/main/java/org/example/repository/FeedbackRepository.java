package org.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.example.model.Feedback;


public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
}
