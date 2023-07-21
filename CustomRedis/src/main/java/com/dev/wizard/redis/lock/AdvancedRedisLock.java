package com.dev.wizard.redis.lock;

import com.fasterxml.jackson.databind.deser.std.UUIDDeserializer;
import jodd.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.data.redis.core.script.RedisScript;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.UUID;

@Component
public class AdvancedRedisLock extends AbstraRedisLock{
    @Override
    public boolean unLock(String key) {
        String id = redisTemplate.opsForValue().get(LOCK_PREFIX + key);
        String currentThreadId = getThreadUUID();
        if(currentThreadId.equals(id)){
            Boolean reuslt = redisTemplate.delete(LOCK_PREFIX + key);
            removeThreadUUID();
            return Boolean.TRUE.equals(reuslt);
        }
        return false;
    }
}
