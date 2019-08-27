package com.lizhi.weather.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 天气系统响应数据结构
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
@Data
public class WeatherResponse implements Serializable{

    private static final long serialVersionUID = -9154518181082058292L;

    /**
     * 状态码
     */
    private Integer status;
    /**
     * 响应数据
     */
    private Weather data;
    /**
     * 响应描述
     */
    private String desc;
}
