package com.dev.wizard.redis.config;


import com.dev.wizard.redis.demo.MyRedisCacheClass;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisClusterConfiguration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;


@Configuration
//@ConfigurationProperties(prefix = "spring.redis.cluster")
@EnableCaching
public class MyRedisConfig extends CachingConfigurerSupport {

    private Set<String> nodes;
    private String master;

//    @Value("${spring.redis.timeout}")
//    private long timeout;
//    @Value("${spring.redis.lettuce.pool.max-idle}")
//    private int maxIdle;
//    @Value("${spring.redis.lettuce.pool.min-idle}")
//    private int minIdle;
//    @Value("${spring.redis.lettuce.pool.max-wait}")
//    private long maxWait;
//    @Value("${spring.redis.lettuce.pool.max-active}")
//    private int maxActive;


    public static final String REDIS_PREFIX = "my";

    @Bean(name = "redisTemplate")
    public StringRedisTemplate redisTemplate(RedisConnectionFactory redisConnectionFactory){

        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate();
        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
//        //参照StringRedisTemplate内部实现指定序列化器
//        redisTemplate.setConnectionFactory(redisConnectionFactory);
//        redisTemplate.setKeySerializer(keySerializer());
//        redisTemplate.setHashKeySerializer(keySerializer());
//        redisTemplate.setValueSerializer(valueSerializer());
//        redisTemplate.setHashValueSerializer(valueSerializer());
        return stringRedisTemplate;
    }
    @Bean(name="customRedisTemplate")
    public StringRedisTemplate customRedisTemplate(RedisConnectionFactory redisConnectionFactory) {
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
        return stringRedisTemplate;
    }
    @Bean
    public MyRedisCacheClass myRedisCacheClass(StringRedisTemplate redisTemplate){
      return new MyRedisCacheClass(redisTemplate, REDIS_PREFIX);
    }



    /**
     * 创建一个redis连接工厂
     * @return
     */
//
//    public RedisConnectionFactory lettuceConnectionFactory() {
//
//        RedisClusterConfiguration redisClusterConfiguration= new RedisClusterConfiguration(nodes);
//
//        GenericObjectPoolConfig genericObjectPoolConfig = new GenericObjectPoolConfig();
//        genericObjectPoolConfig.setMaxIdle(maxIdle);
//        genericObjectPoolConfig.setMinIdle(minIdle);
//        genericObjectPoolConfig.setMaxTotal(maxActive);
//        genericObjectPoolConfig.setMaxWaitMillis(maxWait);
//
//        LettucePoolingClientConfiguration lettuceClientConfiguration = LettucePoolingClientConfiguration.builder()
//                .poolConfig(genericObjectPoolConfig)
//                .build();
//        return new LettuceConnectionFactory(redisClusterConfiguration, lettuceClientConfiguration);
//    }

    public void setNodes(Set<String> nodes){
        this.nodes = nodes;
    }
}
