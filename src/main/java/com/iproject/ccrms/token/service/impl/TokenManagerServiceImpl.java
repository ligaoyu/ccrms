package com.iproject.ccrms.token.service.impl;

import com.iproject.ccrms.base.constant.Constants;
import com.iproject.ccrms.token.model.TokenModel;
import com.iproject.ccrms.token.service.TokenManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by ligaoyu on 18/1/17.
 */
@Component
public class TokenManagerServiceImpl implements TokenManagerService{

    private RedisTemplate redis;

    @Autowired
    public void setRedis(StringRedisTemplate redis) {
        this.redis = redis;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    public TokenModel createToken(Integer userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        //存储到redis并设置过期时间
        redis.boundValueOps(token).set(userId.toString(), Constants.TOKEN_EXPIRES_HOUR, TimeUnit.MINUTES);
        return model;
    }

    public TokenModel getUserIdFromToken(String token) {
        if (token == null || token.length() == 0) {
            return null;
        }
        Object userId =  redis.boundValueOps(token).get();

        if(userId == null){
            return null;
        }

        return new TokenModel((Integer) userId, token);
    }

    public boolean checkToken(String token) {
        if (token == null || token.length() == 0) {
            return false;
        }
        Object userId = redis.boundValueOps(token).get();
        if (userId == null) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.boundValueOps(token).expire(Constants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    public void deleteToken(String token) {
        redis.delete(token);
    }
}
