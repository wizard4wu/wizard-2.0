package com.dev.wizard.redis.lock;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 此实现方式没有对锁设置过期时间 当服务宕机或者程序中断时会造成死锁
 * 解锁的时候没有线程校验 会产生别的线程误删的情况
 */
@Component
public class JuniorRedisLock extends AbstraRedisLock{

    @Autowired
    private StringRedisTemplate redisTemplate;
    @Override
    public boolean lock(String key) {
        long id = Thread.currentThread().getId();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + key, id + "");
        return Boolean.TRUE.equals(result);
    }

    @Override
    public boolean unLock(String key) {
        Boolean reuslt = redisTemplate.delete(LOCK_PREFIX + key);
        return Boolean.TRUE.equals(reuslt);
    }
}
