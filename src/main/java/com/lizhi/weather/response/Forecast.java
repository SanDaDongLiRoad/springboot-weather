package com.lizhi.weather.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 预报
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
@Data
public class Forecast implements Serializable{

    private static final long serialVersionUID = 5534674273936719830L;
    /**
     * 日期
     */
    private String date;
    /**
     * 最高温
     */
    private String high;
    /**
     * 风力
     */
    private String fengli;
    /**
     * 最低温
     */
    private String low;
    /**
     * 风向
     */
    private String fengxiang;
    /**
     * 天气类型
     */
    private String type;
}
