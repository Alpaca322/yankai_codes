package com.example.mapper;
import com.example.dto.WeatherDTO;
import com.example.entity.Weather;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.example.entity.WeatherQueryParam;
import java.util.List;

@Mapper
public interface WeatherMapper {
    List<Weather> selectList(@Param("param") WeatherQueryParam param);

    void insert(WeatherDTO weather);

    void updateById(WeatherDTO weather);

    void deleteById(Integer id);
}
