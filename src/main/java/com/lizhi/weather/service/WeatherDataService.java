package com.lizhi.weather.service;

import com.lizhi.weather.response.Weather;

/**
 * 天气数据业务类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
public interface WeatherDataService {

    /**
     * 根据城市ID查询天气数据
     *
     * @param cityId
     * @return
     */
    Weather getDataByCityId(String cityId);

    /**
     * 根据城市名称查询天气数据
     *
     * @param cityName
     * @return
     */
    Weather getDataByCityName(String cityName);

    /**
     * 根据城市ID来同步天气
     * @param cityId
     */
    void syncWeatherDataByCityId(String cityId);
}
