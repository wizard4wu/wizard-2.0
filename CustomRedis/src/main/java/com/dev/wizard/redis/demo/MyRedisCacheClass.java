package com.dev.wizard.redis.demo;


import com.dev.wizard.redis.cache.MyRedisCache;
import com.dev.wizard.redis.cache.impl.ValueCache;
import com.dev.wizard.redis.config.MyRedisConfig;
import lombok.experimental.Delegate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.util.StringUtils;

public class MyRedisCacheClass<V> implements MyRedisCache<String, V> {

    @Delegate
    private ValueOperations<String, V> valueCache;

    public MyRedisCacheClass(StringRedisTemplate stringRedisTemplate, String prefixString){
        String prefix = StringUtils.isEmpty(prefixString)? prefixString: MyRedisConfig.REDIS_PREFIX;
        this.valueCache = new ValueCache(stringRedisTemplate, prefix.concat("-v1"));
    }
}
