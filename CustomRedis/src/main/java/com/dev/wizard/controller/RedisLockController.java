package com.dev.wizard.controller;

import com.dev.wizard.redis.domain.Stock;
import com.dev.wizard.redis.lock.RedisLock;
import com.dev.wizard.redis.lock.RedisLocked;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

@RequestMapping("/redislock")
@RestController
@Slf4j
public class RedisLockController {

    @Autowired
    private RedisLock redisLock;
    @Autowired
    private StringRedisTemplate redisTemplate;

    private int soldTicket = 0;

    private Stock stock = new Stock();

    private static AtomicInteger atomicInteger = new AtomicInteger(1);

    @RequestMapping("/testLock")
    public void testLock(){
        String productId = "productId000000";
        boolean result = redisLock.lock(productId);
        if(!result){
            return;
        }
        try {
            soldTicket += 1;
            log.info("soldTicket: {}", soldTicket);
        }finally {
            redisLock.unLock(productId);
        }
    }
    @RequestMapping("/testLock2")
    public void testLock2(){
        log.info("start to execute request: {}", atomicInteger.getAndIncrement());
        String key = "product01";
        redisLock.executeWithRedisLock(key, -1, 150, () ->{
            String stock = redisTemplate.opsForValue().get(key);
            if(stock == null){
                redisTemplate.opsForValue().set(key, 1 + "");
            }else {
                int value = Integer.parseInt(stock) + 1;
                redisTemplate.opsForValue().set(key, value + "");
            }
            redisTemplate.opsForSet().add(key + "set", stock);
            log.info("soldTicket: {}", stock);
            return stock;
        });
    }
    @RequestMapping("/testLock3")
    @RedisLocked(key = "product01", lockExpiredTime = 100, tryLockTime = 100)
    public void testLock3(){
        String key = "product01";
        String stock = redisTemplate.opsForValue().get(key);
        if(stock == null){
            redisTemplate.opsForValue().set(key, 1 + "");
        }else {
            int value = Integer.parseInt(stock) + 1;
            redisTemplate.opsForValue().set(key, value + "");
        }
        redisTemplate.opsForSet().add(key + "set", stock);
        log.info("soldTicket: {}", stock);
    }

    @RequestMapping("/checkLock")
    public List<String> check(@RequestParam("test") int value ){
        List<String> list = new ArrayList<>();
        Set<String> set = redisTemplate.opsForSet().members("product01" + "set");
        for(int index = 0; index < value; index ++){
            if(!set.contains(index + "")){
                list.add(index + "");
            }
        }
        return list;
    }
}
