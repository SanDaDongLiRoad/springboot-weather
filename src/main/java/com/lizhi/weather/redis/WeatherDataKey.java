package com.lizhi.weather.redis;

/**
 * 天气数据
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
public class WeatherDataKey extends BasePrefix{

    public WeatherDataKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public static WeatherDataKey weatherData = new WeatherDataKey(1800, "go");
}
