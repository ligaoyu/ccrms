package com.iproject.ccrms.base.redis.service.impl;

import com.iproject.ccrms.base.redis.service.RedisService;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ligaoyu on 18/1/16.
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Resource
    private RedisTemplate<String,Object> redisTemplate;

    public void set(String key, Object value) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        vo.set(key, value);
    }
    public Object get(String key) {
        ValueOperations<String,Object> vo = redisTemplate.opsForValue();
        return vo.get(key);
    }

}
