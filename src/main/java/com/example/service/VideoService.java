package com.example.service;

import com.example.entity.Video;
import com.example.utils.Result;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface VideoService {

    /**
     * 获取视频列表
     */
    Result getVideoList();

    /**
     * 添加视频
     */
    Result addVideo(Video video);

    /**
     * 更新视频
     */
    Result updateVideo(Video video);

    /**
     * 根据id获取视频
     */
    Result getVideoById(Long id);

    /**
     * 删除视频
     */
    Result deleteVideo(Long id);

    /**
     * 查询视频
     */
    Result query(String location, String status);

    /**
     * 上传视频文件
     */
    Result uploadVideo(MultipartFile file);


}