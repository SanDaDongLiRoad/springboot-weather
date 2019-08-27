package com.lizhi.weather.controller;

import com.lizhi.weather.response.Weather;
import com.lizhi.weather.service.WeatherDataService;
import com.lizhi.weather.utils.ResultUtil;
import com.lizhi.weather.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 天气预报
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
@Slf4j
@RestController
@RequestMapping("weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    /**
     * 根据城市编码查询城市天气
     * @param cityId
     * @return
     */
    @GetMapping("cityId/{cityId}")
    public ResultVO<Weather> getWeatherByCityId(@PathVariable("cityId") String cityId) {

        log.info("根据城市编码查询城市天气 cityId:{}",cityId);
        Weather weather = weatherDataService.getDataByCityId(cityId);
        log.info("根据城市编码查询城市天气 result:{}",weather);
        return ResultUtil.success(weather);
    }

    /**
     * 根据城市名称查询城市天气
     * @param cityName
     * @return
     */
    @GetMapping("cityName")
    public ResultVO<Weather> getWeatherByCityName(@RequestParam("cityName") String cityName) {

        log.info("根据城市名称查询城市天气 cityName:{}",cityName);
        Weather weather = weatherDataService.getDataByCityName(cityName);
        log.info("根据城市名称查询城市天气 result:{}",weather);
        return ResultUtil.success(weather);
    }

}
