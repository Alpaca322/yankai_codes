package com.example.controller;

import com.example.dto.WeatherDTO;
import com.example.entity.WeatherQueryParam;
import com.example.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.example.service.WeatherService;


@RestController
@RequestMapping("/weather")
@Api(tags = "天气数据管理")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/list")
    @ApiOperation("获取天气数据列表")
    public Result list(WeatherQueryParam param) {
        // 分页查询参数: pageNum, pageSize, city(可选)
        return weatherService.getWeatherList(param);
    }

    @PostMapping
    @ApiOperation("新增天气数据")
    public Result add(@RequestBody WeatherDTO weather) {
        return weatherService.addWeather(weather);
    }

    @PutMapping("/{id}")
    @ApiOperation("修改天气数据")
    public Result update(@PathVariable Integer id, @RequestBody WeatherDTO weather) {
        weather.setId(id);
        return weatherService.updateWeather(weather);
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除天气数据")
    public Result delete(@PathVariable Integer id) {
        return weatherService.deleteWeather(id);
    }


    @GetMapping("/gaode")
    @ApiOperation("从高德获取天气数据")
    public Result getWeatherFromGaode(@RequestParam String city) {
        return weatherService.getWeatherFromGaode(city);
    }
}