package com.example.controller;

import com.example.entity.Video;
import com.example.service.VideoService;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/video")
@Api(tags = "视频模块")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    @ApiOperation(value = "获取视频列表")
    public Result getVideoList() {
        return videoService.getVideoList();
    }

    @PostMapping
    @ApiOperation(value = "添加视频")
    public Result addVideo(@RequestBody Video video) {
        return videoService.addVideo(video);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "更新视频")
    public Result updateVideo(@PathVariable Long id, @RequestBody Video video) {
        video.setVideoID(id);
        return videoService.updateVideo(video);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "获取视频详情")
    public Result getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除视频")
    public Result deleteVideo(@PathVariable Long id) {
        return videoService.deleteVideo(id);
    }

    @GetMapping("/query")
    @ApiOperation(value = "查询视频")
    public Result query(@RequestParam(required = false) String location,
                        @RequestParam(required = false) String status) {
        return videoService.query(location, status);
    }

    @PostMapping("/upload")
    @ApiOperation(value = "上传视频")
    public Result uploadVideo(@RequestParam("file") MultipartFile file) {
        return videoService.uploadVideo(file);
    }

//    @GetMapping("/file/**")
//    public void getVideoFile(HttpServletRequest request,
//                             HttpServletResponse response) {
//        videoService.getVideoFile(request, response);
//    }
}