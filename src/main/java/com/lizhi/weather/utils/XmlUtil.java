package com.lizhi.weather.utils;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

/**
 * Xml 相关工具类
 *
 * @author xulizhi-lenovo
 * @date 2019/8/27
 */
public class XmlUtil {

    /**
     * 将XML转为指定的POJO
     * @param clazz
     * @param xmlStr
     * @param <T>
     * @return
     */
    public static <T> T xmlStrToOject(Class<T> clazz, String xmlStr){

        T xmlObject = null;
        try(Reader reader = new StringReader(xmlStr)){
            JAXBContext context = JAXBContext.newInstance(clazz);
            // XML 转为对象的接口
            Unmarshaller unmarshaller = context.createUnmarshaller();
            xmlObject = (T) unmarshaller.unmarshal(reader);
        } catch (IOException e){
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return xmlObject;
    }
}
