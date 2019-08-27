package com.lizhi.weather.redis;

/**
 * redis key
 *
 * @author xulizhi-MaginBook
 * @date 2019/5/19
 */
public abstract class BasePrefix implements KeyPrefix{
	
	private int expireSeconds;
	
	private String prefix;

	public BasePrefix(int expireSeconds, String prefix) {
		this.expireSeconds = expireSeconds;
		this.prefix = prefix;
	}

	public BasePrefix(String prefix) {//0代表永不过期
		this(0, prefix);
	}
	

	
	@Override
	public int expireSeconds() {//默认0代表永不过期
		return expireSeconds;
	}

	@Override
	public String getPrefix() {
		String className = getClass().getSimpleName();
		return className+":" + prefix;
	}

}
