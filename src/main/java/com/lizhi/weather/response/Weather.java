package com.lizhi.weather.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 天气信息
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
@Data
public class Weather implements Serializable {

    private static final long serialVersionUID = 1674806154097809175L;

    /**
     * 城市
     */
    private String city;
    /**
     * 指数
     */
    private String aqi;
    /**
     * 感冒情况
     */
    private String ganmao;
    /**
     * 温度
     */
    private String wendu;
    /**
     * 昨天天气
     */
    private Yeaterday yesterday;
    /**
     * 未来天气列表
     */
    private List<Forecast> forecast;
}
