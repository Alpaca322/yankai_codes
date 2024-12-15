package com.example.mapper;

import com.example.entity.Video;
import org.apache.ibatis.annotations.*;
import java.util.List;

@Mapper
public interface VideoMapper {

    @Select("SELECT * FROM VideoSurveillance")
    List<Video> getVideoList();

    @Insert("INSERT INTO VideoSurveillance(FilePath, Location, RecordedAt, Duration, Status) " +
            "VALUES(#{filePath}, #{location}, #{recordedAt}, #{duration}, #{status})")
    @Options(useGeneratedKeys = true, keyProperty = "videoID")
    void addVideo(Video video);

    void updateVideo(Video video);

    @Select("SELECT * FROM VideoSurveillance WHERE VideoID = #{id}")
    Video getVideoById(Long id);

    @Delete("DELETE FROM VideoSurveillance WHERE VideoID = #{id}")
    void deleteVideo(Long id);

    List<Video> query(Video video);
}