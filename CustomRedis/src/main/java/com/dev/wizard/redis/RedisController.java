package com.dev.wizard.redis;


import com.dev.wizard.redis.cache.AutoCache;
import com.dev.wizard.redis.cache.MyRedisCache;
import com.dev.wizard.redis.domain.Student;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    private static ObjectMapper objectMapper = new ObjectMapper();


    @Autowired
    private StringRedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate customRedisTemplate;

    @AutoCache
    private MyRedisCache myRedisCache;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public Student testRedis() throws JsonProcessingException {
        Student stu = new Student();
        stu.setAge(21);
        stu.setName("张三");
        redisTemplate.opsForValue().set("student", objectMapper.writeValueAsString(stu));
        String value = redisTemplate.opsForValue().get("student");
        Student student = objectMapper.readValue(value, Student.class);
        System.out.println(student.toString());
        customRedisTemplate.opsForValue().set("custom", "test");
        myRedisCache.set("ABC", stu);
        //String value = redisDemo.get("key");
        return student;
    }
    @RequestMapping("/setString")
    public void setString(){
        for(int index = 0; index < 1000; index ++)
        redisTemplate.opsForValue().set("key " + index, "value" + index);
    }
    @RequestMapping("/getString")
    @ResponseBody
    public List<String> getString(){
        List<String> list = new ArrayList(1000);
        for(int index = 0; index < 1000; index ++){
            String str = redisTemplate.opsForValue().get("key " + index);
            list.add(str);
        }
       return list;
    }
}
