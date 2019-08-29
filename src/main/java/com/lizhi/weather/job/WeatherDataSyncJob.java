package com.lizhi.weather.job;

import com.lizhi.weather.bean.City;
import com.lizhi.weather.service.CityService;
import com.lizhi.weather.service.WeatherDataService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.quartz.QuartzJobBean;

import java.util.List;

/**
 * 同步天气数据 job
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
@Slf4j
public class WeatherDataSyncJob extends QuartzJobBean {

    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherDataService weatherDataService;

    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        log.info("Weather Data Sync Job. Start！");

        // 获取城市ID列表
        List<City> cityList = cityService.listCity();

        // 遍历城市ID获取天气
        for (City city : cityList) {
            String cityId = city.getCityId();
            log.info("Weather Data Sync Job, cityId:" + cityId);
            weatherDataService.syncWeatherDataByCityId(cityId);
        }

        log.info("Weather Data Sync Job. End！");
    }
}
