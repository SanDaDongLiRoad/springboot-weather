package com.lizhi.weather.service;

import com.lizhi.weather.response.Weather;

/**
 * 天气预报业务类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/29
 */
public interface WeatherReportService {

    /**
     * 根据城市ID获取城市天气数据
     * @param cityId
     * @return
     */
    Weather getWeatherReportByCityId(String cityId);
}
