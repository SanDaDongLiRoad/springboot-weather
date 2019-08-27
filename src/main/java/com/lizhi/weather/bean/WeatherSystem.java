package com.lizhi.weather.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 天气系统相关信息
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
@Data
@Component
@ConfigurationProperties(prefix = "weather.system")
public class WeatherSystem {

    /**
     * 系统访问路径
     */
    private String path;

    /**
     * 天气数据过期时间
     */
    private int timeout;
}
