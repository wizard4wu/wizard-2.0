package com.dev.wizard.springboot.redis.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.aspectj.weaver.ast.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/redis")
public class RedisController {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }

    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @GetMapping("/setRedis")
    public TestObj setRedis(@RequestParam("value") String value) throws IOException {

        TestObj obj = new TestObj(3, value);
        stringRedisTemplate.opsForValue().set("test", objectMapper.writeValueAsString(obj));
        String stringValue = stringRedisTemplate.opsForValue().get("test");

        return objectMapper.readValue(stringValue, TestObj.class);
    }

    static class TestObj{
        private String name;
        private int age;

        @JsonCreator
        public TestObj(@JsonProperty("age") int age, @JsonProperty("name") String name){
            this.age = age;
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
