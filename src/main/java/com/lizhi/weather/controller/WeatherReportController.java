package com.lizhi.weather.controller;

import com.lizhi.weather.service.CityService;
import com.lizhi.weather.service.WeatherReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 天气预报
 *
 * @author xulizhi-lenovo
 * @date 2019/8/29
 */
@Controller
@RequestMapping("report")
public class WeatherReportController {

    @Autowired
    private CityService cityService;

    @Autowired
    private WeatherReportService weatherReportService;

    /**
     * 首页
     * @param cityId
     * @param model
     * @return
     */
    @GetMapping("cityId/{cityId}")
    public String getReportByCityId(@PathVariable("cityId") String cityId, Model model){
        model.addAttribute("title", "天气预报");
        model.addAttribute("cityId", cityId);
        model.addAttribute("cityList", cityService.listCity());
        model.addAttribute("report", weatherReportService.getWeatherReportByCityId(cityId));
        return "report";
    }
}
