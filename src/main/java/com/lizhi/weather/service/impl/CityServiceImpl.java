package com.lizhi.weather.service.impl;

import com.lizhi.weather.bean.Areas;
import com.lizhi.weather.bean.City;
import com.lizhi.weather.service.CityService;
import com.lizhi.weather.utils.XmlUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * 城市业务类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
@Slf4j
@Service
public class CityServiceImpl implements CityService {

    @Override
    public List<City> listCity() {
        // 读取XML文件
        Resource resource = new ClassPathResource("city-list.xml");
        StringBuffer areasJsonStr = new StringBuffer();
        try(BufferedReader br = new BufferedReader(new InputStreamReader(resource.getInputStream(), "utf-8"))){
            String line = "";
            while ((line = br.readLine()) !=null) {
                areasJsonStr.append(line);
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // XML转为Java对象
        Areas areas = XmlUtil.xmlStrToOject(Areas.class, areasJsonStr.toString());
        return areas.getCityList();
    }
}
