package com.example.service;

import com.example.dto.WeatherDTO;
import com.example.entity.WeatherQueryParam;
import com.example.utils.Result;

public interface WeatherService {
    /**
     * 获取天气数据列表
     */
    Result getWeatherList(WeatherQueryParam param);

    /**
     * 从高德获取天气数据
     */
    Result getWeatherFromGaode(String city);

    /**
     * 新增天气数据
     */
    Result addWeather(WeatherDTO weather);

    /**
     * 修改天气数据
     */
    Result updateWeather(WeatherDTO weather);

    /**
     * 删除天气数据
     */
    Result deleteWeather(Integer id);
}