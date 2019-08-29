package com.lizhi.weather.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.lizhi.weather.bean.WeatherSystem;
import com.lizhi.weather.redis.WeatherDataKey;
import com.lizhi.weather.response.Weather;
import com.lizhi.weather.response.WeatherResponse;
import com.lizhi.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * 天气数据业务类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
@Slf4j
@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    @Autowired
    private WeatherSystem weatherSystem;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public Weather getDataByCityId(String cityId) {

        log.info("根据城市编码查询城市天气 cityId:{}",cityId);

        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(WeatherDataKey.weatherData.getPrefix() + cityId)) {
            log.info("取缓存中的天气数据");
            String weatherDataStr = stringRedisTemplate.opsForValue().get(WeatherDataKey.weatherData.getPrefix()+cityId);
            Weather weather = JSONObject.parseObject(weatherDataStr,Weather.class);
            log.info("根据城市编码查询城市天气 result:{}",weather);
            return weather;
        }

        //调用天气系统获取天气数据
        ResponseEntity<String> weatherSystemResponse = restTemplate.getForEntity(weatherSystem.getPath()+"?citykey="+cityId,String.class);
        log.info("天气系统响应结果 result:{}",weatherSystemResponse);
        if (!Objects.equals(null,weatherSystemResponse) && Objects.equals(weatherSystemResponse.getStatusCodeValue(),200)) {
            String weatherDataStr = weatherSystemResponse.getBody();
            WeatherResponse weatherResponse = JSONObject.parseObject(weatherDataStr, WeatherResponse.class);
            if(Objects.equals(weatherResponse.getStatus(),1000)) {
                stringRedisTemplate.opsForValue().set(WeatherDataKey.weatherData.getPrefix() + cityId, JSONObject.toJSONString(weatherResponse.getData()),WeatherDataKey.weatherData.expireSeconds(), TimeUnit.SECONDS);
            }
            log.info("天气数据结果 result:{}",weatherResponse.getDesc());
            return weatherResponse.getData();
        }
        return null;
    }

    @Override
    public Weather getDataByCityName(String cityName) {
        log.info("根据城市名称查询城市天气 cityName:{}",cityName);

        // 先查缓存，缓存有的取缓存中的数据
        if (stringRedisTemplate.hasKey(WeatherDataKey.weatherData.getPrefix() + cityName)) {
            log.info("取缓存中的天气数据");
            String weatherDataStr = stringRedisTemplate.opsForValue().get(WeatherDataKey.weatherData.getPrefix()+cityName);
            Weather weather = JSONObject.parseObject(weatherDataStr,Weather.class);
            log.info("根据城市名称查询城市天气 result:{}",weather);
            return weather;
        }

        //调用天气系统获取天气数据
        ResponseEntity<String> weatherSystemResponse = restTemplate.getForEntity(weatherSystem.getPath()+"?city="+cityName,String.class);
        log.info("天气系统响应结果 result:{}",weatherSystemResponse);
        if (!Objects.equals(null,weatherSystemResponse) && Objects.equals(weatherSystemResponse.getStatusCodeValue(),200)) {
            String weatherDataStr = weatherSystemResponse.getBody();
            WeatherResponse weatherResponse = JSONObject.parseObject(weatherDataStr, WeatherResponse.class);
            if(Objects.equals(weatherResponse.getStatus(),1000)) {
                stringRedisTemplate.opsForValue().set(WeatherDataKey.weatherData.getPrefix() + cityName, JSONObject.toJSONString(weatherResponse.getData()),WeatherDataKey.weatherData.expireSeconds(), TimeUnit.SECONDS);
            }
            log.info("根据城市名称查询城市天气 result:{}",weatherResponse.getDesc());
            return weatherResponse.getData();
        }
        return null;
    }

    @Override
    public void syncWeatherDataByCityId(String cityId) {
        log.info("开始同步天气数据 cityId:{}",cityId);

        //调用天气系统获取天气数据
        ResponseEntity<String> weatherSystemResponse = restTemplate.getForEntity(weatherSystem.getPath()+"?citykey="+cityId,String.class);
        log.info("天气系统响应结果 result:{}",weatherSystemResponse);
        if (!Objects.equals(null,weatherSystemResponse) && Objects.equals(weatherSystemResponse.getStatusCodeValue(),200)) {
            String weatherDataStr = weatherSystemResponse.getBody();
            WeatherResponse weatherResponse = JSONObject.parseObject(weatherDataStr, WeatherResponse.class);
            if(Objects.equals(weatherResponse.getStatus(),1000)) {
                stringRedisTemplate.opsForValue().set(WeatherDataKey.weatherData.getPrefix() + cityId, JSONObject.toJSONString(weatherResponse.getData()),WeatherDataKey.weatherData.expireSeconds(), TimeUnit.SECONDS);
            }
            log.info("天气数据结果 result:{}",weatherResponse.getDesc());
        }
    }
}
