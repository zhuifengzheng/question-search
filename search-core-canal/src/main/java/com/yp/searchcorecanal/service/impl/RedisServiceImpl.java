package com.yp.searchcorecanal.service.impl;

import com.yp.searchcorecanal.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

/**
 * @Author by yuanpeng
 * @Date 2020/7/5
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Override
    public void set(String key, Object value) {
        redisTemplate.opsForValue().set(key,value);
    }

    @Override
    public void set(String key, Object value, long expires) {
        redisTemplate.opsForValue().set(key,value,expires);
    }

    @Override
    public <T> T get(String key, Class<T> clazz) {
        return (T)redisTemplate.opsForValue().get(key);
    }
}
