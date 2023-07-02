package com.dev.wizard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
@RequestMapping("/docker")
@Slf4j
public class DockerController {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
    private AtomicInteger atomicInteger = new AtomicInteger(0);
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/get/hello")
    public String get(@RequestParam("value") String value){
        System.out.println("DockerController###get, value: " + atomicInteger.incrementAndGet());
        return "Hello World" + value;
    }

    @GetMapping("/redis/set")
    public String setRedisData(@RequestParam("value") String value){
        String key = "docker";
        stringRedisTemplate.opsForValue().set(key, value);
        String strValue = stringRedisTemplate.opsForValue().get(key);
        return strValue;
    }

}
