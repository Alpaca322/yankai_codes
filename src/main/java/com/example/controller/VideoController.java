package com.example.controller;

import com.example.entity.Video;
import com.example.service.VideoService;
import com.example.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/video")
public class VideoController {

    @Autowired
    private VideoService videoService;

    @GetMapping("/list")
    public Result getVideoList() {
        return videoService.getVideoList();
    }

    @PostMapping
    public Result addVideo(@RequestBody Video video) {
        return videoService.addVideo(video);
    }

    @PutMapping("/{id}")
    public Result updateVideo(@PathVariable Long id, @RequestBody Video video) {
        video.setVideoID(id);
        return videoService.updateVideo(video);
    }

    @GetMapping("/{id}")
    public Result getVideoById(@PathVariable Long id) {
        return videoService.getVideoById(id);
    }

    @DeleteMapping("/{id}")
    public Result deleteVideo(@PathVariable Long id) {
        return videoService.deleteVideo(id);
    }

    @GetMapping("/query")
    public Result query(@RequestParam(required = false) String location,
                        @RequestParam(required = false) String status) {
        return videoService.query(location, status);
    }

    @PostMapping("/upload")
    public Result uploadVideo(@RequestParam("file") MultipartFile file) {
        return videoService.uploadVideo(file);
    }

//    @GetMapping("/file/**")
//    public void getVideoFile(HttpServletRequest request,
//                             HttpServletResponse response) {
//        videoService.getVideoFile(request, response);
//    }
}