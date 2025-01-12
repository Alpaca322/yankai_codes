package com.example.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Weather {
        private Integer id;
        private String city;        // 城市
        private Float temperature;  // 温度
        private Float humidity;     // 湿度
        private Float wind;         // 风速
        private String creator_id;     // 创建者
        private String creator;// 创建者
        private Date create_time;    // 创建时间
}
