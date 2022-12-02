package com.dev.wizard.config;

import com.dev.wizard.bean.BeanD;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Slf4j
public class BeanConfiguration {

    public BeanConfiguration(){
       log.info("BeanConfiguration + Constructor");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("BeanConfiguration + postConstruct");
    }

    @Bean(initMethod = "init")
    public BeanD beanD(){
        return new BeanD();
    }
}
