package com.dev.wizard.redis.cache.impl;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.data.redis.connection.BitFieldSubCommands;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.time.Duration;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class ValueCache<V> implements ValueOperations<String, V> {
    private static ObjectMapper objectMapper = new ObjectMapper();

    private StringRedisTemplate stringRedisTemplate;

    private String prefixString;

    public ValueCache(StringRedisTemplate stringRedisTemplate, String prefixString){
       this.stringRedisTemplate = stringRedisTemplate;
       this.prefixString = prefixString;
    }

    private String setPrefix(String key){
        return prefixString.concat(key);
    }

    @SneakyThrows
    @Override
    public void set(String key, V value) {
       String valueAsString = objectMapper.writeValueAsString(value);
       stringRedisTemplate.opsForValue().set(setPrefix(key), valueAsString);
    }

    @Override
    public void set(String key, V value, long timeout, TimeUnit unit) {

    }

    @Override
    public Boolean setIfAbsent(String key, V value) {
        return null;
    }

    @Override
    public Boolean setIfAbsent(String key, V value, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public Boolean setIfPresent(String key, V value) {
        return null;
    }

    @Override
    public Boolean setIfPresent(String key, V value, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public void multiSet(Map<? extends String, ? extends V> map) {

    }

    @Override
    public Boolean multiSetIfAbsent(Map<? extends String, ? extends V> map) {
        return null;
    }

    @Override
    public V get(Object key) {
        return null;
    }

    @Override
    public V getAndDelete(String key) {
        return null;
    }

    @Override
    public V getAndExpire(String key, long timeout, TimeUnit unit) {
        return null;
    }

    @Override
    public V getAndExpire(String key, Duration timeout) {
        return null;
    }

    @Override
    public V getAndPersist(String key) {
        return null;
    }

    @Override
    public V getAndSet(String key, V value) {
        return null;
    }

    @Override
    public List<V> multiGet(Collection<String> keys) {
        return null;
    }

    @Override
    public Long increment(String key) {
        return null;
    }

    @Override
    public Long increment(String key, long delta) {
        return null;
    }

    @Override
    public Double increment(String key, double delta) {
        return null;
    }

    @Override
    public Long decrement(String key) {
        return null;
    }

    @Override
    public Long decrement(String key, long delta) {
        return null;
    }

    @Override
    public Integer append(String key, String value) {
        return null;
    }

    @Override
    public String get(String key, long start, long end) {
        return null;
    }

    @Override
    public void set(String key, V value, long offset) {

    }

    @Override
    public Long size(String key) {
        return null;
    }

    @Override
    public Boolean setBit(String key, long offset, boolean value) {
        return null;
    }

    @Override
    public Boolean getBit(String key, long offset) {
        return null;
    }

    @Override
    public List<Long> bitField(String key, BitFieldSubCommands subCommands) {
        return null;
    }

    @Override
    public RedisOperations<String, V> getOperations() {
        return null;
    }


}
