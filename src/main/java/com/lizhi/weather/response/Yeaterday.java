package com.lizhi.weather.response;

import lombok.Data;

import java.io.Serializable;

/**
 * 昨天天气
 *
 * @author xulizhi-lenovo
 * @date 2019/8/26
 */
@Data
public class Yeaterday implements Serializable {

    private static final long serialVersionUID = 1080341147328102523L;
    /**
     * 日期
     */
    private String date;
    /**
     * 最高温
     */
    private String high;
    /**
     * 风向
     */
    private String fx;
    /**
     * 最低温
     */
    private String low;
    /**
     * 风力
     */
    private String fl;
    /**
     * 天气类型
     */
    private String type;
}
