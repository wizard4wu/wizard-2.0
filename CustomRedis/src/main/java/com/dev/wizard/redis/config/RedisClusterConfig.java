package com.dev.wizard.redis.config;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Configuration
@Slf4j
public class RedisClusterConfig {

    @Autowired
    private RedisClusterPool redisClusterPool;
    @Autowired
    private RedisClusterProperties redisClusterProperties;

    @Bean(name = "redisTemplate")
    public StringRedisTemplate redisTemplate(){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(jedisConnectionFactory());
        return stringRedisTemplate;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory() {
        String[] nodes = redisClusterProperties.getNodes().split(",");
        RedisClusterConfiguration configuration = new RedisClusterConfiguration(Arrays.stream(nodes).toList());
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(configuration);
        jedisConnectionFactory.setPoolConfig(initJedisPool());
        log.info("init jedisConnectionFactory");
        return jedisConnectionFactory;
    }

    private JedisPoolConfig initJedisPool(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(redisClusterPool.getMaxIdle());       // 最大空闲连接数, 默认8个
        jedisPoolConfig.setMaxTotal(redisClusterPool.getMaxActive());    // 最大连接数, 默认8个
        jedisPoolConfig.setMinIdle(redisClusterPool.getMinIdle());       // 最小空闲连接数, 默认0
        jedisPoolConfig.setMaxWaitMillis(redisClusterPool.getMaxWait()); // 获取连接时的最大等待毫秒数(如果设置为阻塞时BlockWhenExhausted),如果超时就抛异常, 小于零:阻塞不确定的时间,  默认-1
        jedisPoolConfig.setTestOnBorrow(true);                              // 对拿到的connection进行validateObject校验
        return jedisPoolConfig;
    }
}
