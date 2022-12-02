package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

import javax.annotation.PostConstruct;

@Slf4j
public class BeanD implements InitializingBean {

    public BeanD(){
        log.info("BeanD + Constructor");
    }

    @PostConstruct
    public void postConstruct(){
        log.info("BeanD + postConstruct");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("BeanD + afterPropertiesSet");
    }

    public void init() {
        log.info("BeanD + init");
    }
}
