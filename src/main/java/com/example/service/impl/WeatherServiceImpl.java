package com.example.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.dto.WeatherDTO;
import com.example.entity.Weather;
import com.example.entity.WeatherQueryParam;
import com.example.mapper.WeatherMapper;
import com.example.service.WeatherService;
import com.example.utils.Result;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.github.pagehelper.PageHelper;
import org.springframework.web.client.RestTemplate;
import com.alibaba.fastjson.JSON;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class WeatherServiceImpl implements WeatherService {
    @Value("${gaode.key}")
    private String gaodeKey;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherMapper weatherMapper;

    @Override
    public Result getWeatherFromGaode(String city) {
        try {
            String url = String.format(
                    "https://restapi.amap.com/v3/weather/weatherInfo?key=%s&city=%s&extensions=base",
                    gaodeKey, city
            );

            ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);
            JSONObject json = JSON.parseObject(response.getBody());

            if ("1".equals(json.getString("status"))) {
                JSONObject lives = json.getJSONArray("lives").getJSONObject(0);

                WeatherDTO weather = new WeatherDTO();
                weather.setCity(lives.getString("city"));
                weather.setTemperature(Float.parseFloat(lives.getString("temperature")));
                weather.setHumidity(Float.parseFloat(lives.getString("humidity")));

                // 处理风力等级
                String windpower = lives.getString("windpower");
                float wind;
                if (windpower.contains("≤")) {
                    // 如果包含 ≤，取后面的数字
                    wind = Float.parseFloat(windpower.substring(1));
                } else if (windpower.contains("-")) {
                    // 如果是范围，如 "3-4"，取平均值
                    String[] range = windpower.split("-");
                    wind = (Float.parseFloat(range[0]) + Float.parseFloat(range[1])) / 2;
                } else {
                    // 直接是数字
                    wind = Float.parseFloat(windpower);
                }
                weather.setWind(wind);

                weather.setCreateTime(new Date());
                weather.setCreator("系统");

                System.out.println(weather);

                // 保存到数据库
                weatherMapper.insert(weather);

                return Result.success();
            } else {
                return Result.error("获取天气数据失败: " + json.getString("info"));
            }
        } catch (Exception e) {
            log.error("获取高德天气数据失败", e);
            return Result.error("获取天气数据失败: " + e.getMessage());
        }
    }

    @Override
    public Result getWeatherList(WeatherQueryParam param) {
        PageHelper.startPage(param.getPageNum(), param.getPageSize());
        List<Weather> list = weatherMapper.selectList(param);
        PageInfo<Weather> pageInfo = new PageInfo<>(list);

        return Result.success(pageInfo);
    }

    @Override
    public Result addWeather(WeatherDTO weather) {
        weather.setCreateTime(new Date());
        // 设置创建者等信息...
        weatherMapper.insert(weather);
        return Result.success();
    }

    @Override
    public Result updateWeather(WeatherDTO weather) {
        weatherMapper.updateById(weather);
        return Result.success();
    }

    @Override
    public Result deleteWeather(Integer id) {
        weatherMapper.deleteById(id);
        return Result.success();
    }


}
