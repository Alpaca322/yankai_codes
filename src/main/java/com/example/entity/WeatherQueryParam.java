package com.example.entity;

import lombok.Data;

@Data
public class WeatherQueryParam {
    private Integer pageNum = 1;
    private Integer pageSize = 10;
    private String city;        // 城市名称(可选)
}