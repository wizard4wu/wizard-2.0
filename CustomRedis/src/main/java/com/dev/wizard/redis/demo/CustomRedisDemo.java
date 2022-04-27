package com.dev.wizard.redis.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

@Service
public class CustomRedisDemo {
    @Autowired
    private StringRedisTemplate customRedisTemplate;

}
