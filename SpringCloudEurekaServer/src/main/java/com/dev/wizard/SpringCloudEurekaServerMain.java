package com.dev.wizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringCloudEurekaServerMain {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudEurekaServerMain.class, args);
    }
}