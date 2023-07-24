package com.dev.wizard.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "spring.redis.pool")
public class RedisClusterPool {
    private int maxActive;
    private int maxWait;
    private int maxIdle;
    private int minIdle;
}
