package com.dev.wizard.redis.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Data
@ConfigurationProperties(prefix = "spring.redis.cluster")
public class RedisClusterProperties {
    List<String> nodes;
}
