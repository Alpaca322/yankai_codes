package com.example.service.impl;

import com.example.entity.Video;
import com.example.exception.BaseException;
import com.example.mapper.VideoMapper;
import com.example.service.VideoService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class VideoServiceImpl implements VideoService {

    @Value("${video.upload.path}")
    private String uploadPath;

    @Autowired
    private VideoMapper videoMapper;

    @Override
    public Result getVideoList() {
        List<Video> videos = videoMapper.getVideoList();
        return Result.success(videos);
    }

    @Override
    public Result addVideo(Video video) {
        if (video.getFilePath() == null || video.getFilePath().isEmpty()) {
            throw new BaseException("文件路径不能为空");
        }
        if (video.getLocation() == null || video.getLocation().isEmpty()) {
            throw new BaseException("拍摄位置不能为空");
        }
        video.setCreatedAt(LocalDateTime.now());
        video.setStatus("Active");
        videoMapper.addVideo(video);
        return Result.success("添加成功");
    }

    @Override
    public Result updateVideo(Video video) {
        if (video.getVideoID() == null) {
            throw new BaseException("视频ID不能为空");
        }
        videoMapper.updateVideo(video);
        return Result.success("更新成功");
    }

    @Override
    public Result getVideoById(Long id) {
        if (id == null) {
            throw new BaseException("id不能为空");
        }
        Video video = videoMapper.getVideoById(id);
        return Result.success(video);
    }

    @Override
    public Result deleteVideo(Long id) {
        if (id == null) {
            throw new BaseException("id不能为空");
        }
        videoMapper.deleteVideo(id);
        return Result.success("删除成功");
    }

    @Override
    public Result query(String location, String status) {
        Video video = new Video();
        video.setLocation(location);
        video.setStatus(status);
        List<Video> videos = videoMapper.query(video);
        return Result.success(videos);
    }

    @Override
    public Result uploadVideo(MultipartFile file) {
        if (file.isEmpty()) {
            throw new BaseException("上传文件不能为空");
        }

        String fileName = file.getOriginalFilename();
        String filePath = uploadPath + fileName;

        try {
            File dest = new File(filePath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            file.transferTo(dest);
            return Result.success(fileName);
        } catch (IOException e) {
            throw new BaseException("文件上传失败");
        }
    }


}