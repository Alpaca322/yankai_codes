package com.example.dto;

import lombok.Data;

import java.util.Date;

@Data
public class WeatherDTO {
    private Integer id;
    private String city;        // 城市
    private Float temperature;  // 温度
    private Float humidity;     // 湿度
    private Float wind;         // 风速
    private String creator;     // 创建者
    private Date createTime;    // 创建时间
}

