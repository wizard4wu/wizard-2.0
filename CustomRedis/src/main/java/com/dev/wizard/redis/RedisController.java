package com.dev.wizard.redis;


import com.dev.wizard.redis.cache.AutoCache;
import com.dev.wizard.redis.cache.MyRedisCache;
import com.dev.wizard.redis.common.PageCacheComponents;
import com.dev.wizard.redis.domain.Order;
import com.dev.wizard.redis.domain.Student;
import com.dev.wizard.redis.dto.OrderDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/redis")
@Slf4j
public class RedisController {
    private static ObjectMapper objectMapper = new ObjectMapper();
    static {
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
    }

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
        redisTemplate.opsForZSet().add("orderId", "ddd", Instant.now().toEpochMilli());
        customRedisTemplate.opsForValue().set("custom", "test");
        myRedisCache.set("ABC", stu);
        //String value = redisDemo.get("key");
        return student;
    }

    @PostMapping("/order/save")
    public Collection<OrderDTO> saveOrder(@RequestBody OrderDTO orderDTO) throws Exception {
        String value = objectMapper.writeValueAsString(orderDTO);

        redisTemplate.opsForZSet().add("userId", value, orderDTO.getEndTime().toEpochMilli());
        //Set<String> stringSet = redisTemplate.opsForZSet().range("userId", 0, -1);

        Set<String> stringSet = redisTemplate.opsForZSet().rangeByScore("userId", Instant.now().toEpochMilli(), Double.POSITIVE_INFINITY);

        return stringSet.stream().map(s -> {
            try {
                return objectMapper.readValue(s, OrderDTO.class);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());
    }

    @Autowired
    private PageCacheComponents pageCacheComponents;


    @GetMapping("/pageCache/generate")
    public void generateData(){
        String key = "productId_" + 9912;
        IntStream.range(0, 100).forEach(number ->{
            log.info("generateData {}" , number);
            Order order = new Order();
            order.setProductId("9912");
            order.setOrderId("orderId_" + number);
            order.setOrderName("orderName_" + number);
            order.setStartTime(Instant.now().plus(number, ChronoUnit.SECONDS));
            try {
                redisTemplate.opsForValue().set(order.getOrderId(), objectMapper.writeValueAsString(order));
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
            pageCacheComponents.addData2Page(key, order);
        });
    }

    @GetMapping("pageCache/order")
    public Collection<Order> getOrderList(@RequestParam("pageSize") int pageSize, @RequestParam("pageNum") int pageNum, @RequestParam(value = "nextPageToken", required = false) Instant nextPageToken){
        String key = "productId_" + 9912;
        //return pageCacheComponents.getPayloadByToken(key, startIndex, 0, pageSize);
        double startIndex = Double.NEGATIVE_INFINITY;
        if(null != nextPageToken){
            startIndex = nextPageToken.toEpochMilli();
        }
        return pageCacheComponents.getPageData(key, startIndex, (pageNum - 1) * pageSize, pageSize);
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
