package com.dev.wizard;

import com.dev.wizard.config.MyEurekaClientConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients(defaultConfiguration = MyEurekaClientConfig.class)
public class SpringCloudEurekaClient {
    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
        SpringApplication.run(SpringCloudEurekaClient.class);
    }
}