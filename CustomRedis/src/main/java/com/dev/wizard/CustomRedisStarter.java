package com.dev.wizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Collections;
import java.util.Map;

@SpringBootApplication
@EnableAspectJAutoProxy
public class CustomRedisStarter {
    public static void main(String[] args) {
        SpringApplication.run(CustomRedisStarter.class, args);
    }
}
