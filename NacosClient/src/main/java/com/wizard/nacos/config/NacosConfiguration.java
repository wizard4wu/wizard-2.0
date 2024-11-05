package com.wizard.nacos.config;


import com.alibaba.nacos.api.config.ConfigFactory;
import com.alibaba.nacos.api.config.ConfigService;
import com.alibaba.nacos.api.exception.NacosException;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Configuration
public class NacosConfiguration {


    @Bean
    public ConfigService nacosConfigService() throws NacosException {
        return ConfigFactory.createConfigService("127.0.0.1:8097");
    }
}
