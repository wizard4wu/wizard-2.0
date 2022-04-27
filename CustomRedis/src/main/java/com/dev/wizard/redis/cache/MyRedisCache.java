package com.dev.wizard.redis.cache;


import org.springframework.data.redis.core.ValueOperations;

public interface MyRedisCache<K, V> extends ValueOperations<K, V>{


}
