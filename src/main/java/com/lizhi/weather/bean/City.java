package com.lizhi.weather.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 城市信息
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
@Data
@XmlRootElement(name = "d")
@XmlAccessorType(XmlAccessType.FIELD)
public class City {

    /**
     * 城市ID
     */
    @XmlAttribute(name = "d1")
    private String cityId;

    /**
     * 城市名称
     */
    @XmlAttribute(name = "d2")
    private String cityName;

    /**
     * 城市编码
     */
    @XmlAttribute(name = "d3")
    private String cityCode;

    /**
     * 所属省份
     */
    @XmlAttribute(name = "d4")
    private String province;
}
