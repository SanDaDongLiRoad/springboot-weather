package com.lizhi.weather.redis;

/**
 * redis key
 *
 * @author xulizhi-lenovo
 * @date 2019/5/17
 */
public interface KeyPrefix {

	/**
	 * 过期时间
	 * @return
	 */
	long expireSeconds();

	/**
	 * 获取前缀
	 * @return
	 */
	String getPrefix();
	
}
