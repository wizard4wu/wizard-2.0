package com.dev.wizard;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootApplication
@EnableFeignClients
@EnableAspectJAutoProxy
@MapperScan("com.dev.wizard.mapper")
public class SpringCloudDemoStarter {
    public static void main(String[] args) {
        SpringApplication.run(SpringCloudDemoStarter.class, args);
    }
}
