package com.lizhi.weather.service;

import com.lizhi.weather.bean.City;

import java.util.List;

/**
 * 城市业务类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
public interface CityService {

    /**
     * 获取城市列表
     * @return
     */
    List<City> listCity();
}
