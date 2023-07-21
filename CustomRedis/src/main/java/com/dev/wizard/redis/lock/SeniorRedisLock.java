package com.dev.wizard.redis.lock;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class SeniorRedisLock extends AbstraRedisLock{
    @Override
    public boolean unLock(String key) {
        String currentThreadId = getThreadUUID();
        Long result = redisTemplate.execute(UNLOCK_SCRIPT, List.of(LOCK_PREFIX + key), currentThreadId);
        removeThreadUUID();
        removeTimer();
        if(result <= 0){
            log.error("unlock exception, key: {}", key);
        }
        return result > 0;
    }




}
