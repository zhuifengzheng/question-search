package com.yp.searchcorecanal.service;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
public interface RedisService {

    void set(String key, Object value);

    void set(String key, Object value, long expires);

    <T> T get(String key, Class<T> clazz);
}
