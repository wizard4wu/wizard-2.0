package com.dev.wizard.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

//@RestController
//@RequestMapping("/docker")
public class DockerController {

    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @GetMapping("/get/hello")
    public String get(@RequestParam("value") String value){
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
