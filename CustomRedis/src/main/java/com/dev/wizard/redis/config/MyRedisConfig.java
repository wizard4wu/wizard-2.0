package com.dev.wizard.redis.config;


import com.dev.wizard.redis.demo.MyRedisCacheClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;


@Configuration
public class MyRedisConfig {

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
    public StringRedisTemplate customRedisTemplate(RedisConnectionFactory redisConnectionFactory){
        StringRedisTemplate stringRedisTemplate = new StringRedisTemplate(redisConnectionFactory);
        return stringRedisTemplate;
    }

    @Bean
    public MyRedisCacheClass myRedisCacheClass(StringRedisTemplate redisTemplate){
      return new MyRedisCacheClass(redisTemplate, REDIS_PREFIX);
    }

}
