package com.example.demo.service.impl;

import com.example.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import java.util.concurrent.TimeUnit;

@Service("redisService")
public class RedisServiceImpl implements RedisService {
    @Autowired
    RedisTemplate<String, String> redisTemplate;

    @Override
    public boolean set(final String key,final String val,long timeout) throws Exception{
        Assert.hasText(key, "redis key is empty");

        boolean result = false;

        try {
            redisTemplate.opsForValue().set(key, val, 60 * 10, TimeUnit.SECONDS);
            result = true;
        }catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public String get(String key) throws Exception {
        String result = "";
        try {
            result= redisTemplate.opsForValue().get(key);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    };
}
