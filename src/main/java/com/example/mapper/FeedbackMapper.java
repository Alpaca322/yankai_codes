package com.example.mapper;

import com.example.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import java.util.List;

@Mapper
public interface FeedbackMapper {
    List<Feedback> selectAll();

    List<Feedback> selectByStatus(@Param("status") String status);

    Feedback selectById(@Param("feedbackid") Long feedbackid);

    int updateStatus(@Param("feedbackid") Long feedbackid, @Param("status") String status);

    int deleteById(@Param("feedbackid") Long feedbackid);

    int insert(Feedback feedback);
}