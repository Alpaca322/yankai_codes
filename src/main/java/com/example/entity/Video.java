package com.example.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Video {
    private Long videoID;        // 视频ID
    private String filePath;     // 文件路径
    private String location;     // 位置
    private LocalDateTime recordedAt;  // 录制时间
    private Integer duration;    // 时长(秒)
    private String status;       // 状态(Active/Archived)
    private LocalDateTime createdAt;  // 创建时间
    private LocalDateTime updatedAt;  // 更新时间
}