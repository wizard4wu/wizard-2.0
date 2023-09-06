package com.dev.wizard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/cluster")
public class RedisClusterController {
    @Autowired
    private StringRedisTemplate redisTemplate;

    @GetMapping("/redis/get")
    public String get(@RequestParam("key")String key, @RequestParam("value") String value){
       return redisTemplate.opsForValue().get(key);
    }
    @GetMapping("/redis/multiget")
    public List<String> multiGet(@RequestParam("key")String key, @RequestParam("value") String value){
        String[] array = key.split(",");
        return redisTemplate.opsForValue().multiGet(Arrays.stream(array).toList());
    }
    @GetMapping("/redis/set")
    public void set(@RequestParam("key")String key, @RequestParam("value") String value){
        redisTemplate.opsForValue().set(key, value);
    }


 }
