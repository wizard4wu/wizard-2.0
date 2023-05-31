package com.dev.wizard.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@Data
@ConfigurationProperties(prefix = "spring.redis-avengers.cluster")
public class RedisClusterProperties {
    List<String> nodes;
}
