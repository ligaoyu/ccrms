package com.iproject.ccrms.base.redis.service;

/**
 * Created by ligaoyu on 18/1/16.
 */
public interface RedisService {

    public void set(String key, Object value);

    public Object get(String key);

}
