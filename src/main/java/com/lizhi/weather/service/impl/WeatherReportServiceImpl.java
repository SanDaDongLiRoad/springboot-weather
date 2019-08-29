package com.lizhi.weather.service.impl;

import com.lizhi.weather.response.Weather;
import com.lizhi.weather.service.WeatherDataService;
import com.lizhi.weather.service.WeatherReportService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 天气数据业务类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/29
 */
@Slf4j
@Service
public class WeatherReportServiceImpl implements WeatherReportService {

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    public Weather getWeatherReportByCityId(String cityId) {
        log.info("根据城市编码查询城市天气 cityId:{}",cityId);
        Weather weather = weatherDataService.getDataByCityId(cityId);
        log.info("根据城市编码查询城市天气 result:{}",weather);
        return weather;
    }
}
