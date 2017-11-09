package com.im4j.service.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.net.URL;

/**
 * Created by chenzp on 2017/11/9 0009.
 */
@Service
public class RedisService {
    @Autowired
    private RedisTemplate<String, String> template;


    public void add(String key, String value) {
        template.opsForValue().set(key, value);
    }

    public String get(String key){
        return template.opsForValue().get(key);
    }
}
