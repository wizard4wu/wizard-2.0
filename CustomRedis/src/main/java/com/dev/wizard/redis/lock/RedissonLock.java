package com.dev.wizard.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
@Slf4j
@Component
@Primary
public class RedissonLock extends AbstraRedisLock{
    @Autowired
    private RedissonClient redissonClient;
    @Override
    public boolean lock(String key) {
        String id = getThreadUUID();
        Boolean result = redisTemplate.opsForValue().setIfAbsent(LOCK_PREFIX + key, id, expiredTime, TimeUnit.SECONDS);
        return Boolean.TRUE.equals(result);
    }

    @Override
    public boolean unLock(String key) {
        return false;
    }

    public <T> T executeWithRedisLock(String lockKey, long lockExpriedTime, long tryLockTime, Supplier<T> suppierForBiz){
        RLock rlock = redissonClient.getLock(LOCK_PREFIX + lockKey);
        boolean locked = false;
        try {
            locked = rlock.tryLock(tryLockTime, lockExpriedTime, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        if(locked){
            try {
              return suppierForBiz.get();
            }catch (Exception e){

            }finally {
                rlock.unlock();
            }
        }
        throw new RuntimeException();
    }

}
