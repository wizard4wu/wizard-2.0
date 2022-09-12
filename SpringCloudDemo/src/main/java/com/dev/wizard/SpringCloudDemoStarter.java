package com.dev.wizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringCloudDemoStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoStarter.class, args);
    }
}
