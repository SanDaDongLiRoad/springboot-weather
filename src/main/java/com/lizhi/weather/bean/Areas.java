package com.lizhi.weather.bean;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * 地区集合
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
@Data
@XmlRootElement(name = "c")
@XmlAccessorType(XmlAccessType.FIELD)
public class Areas {

    @XmlElement(name = "d")
    private List<City> cityList;
}
