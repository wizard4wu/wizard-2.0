package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class ProxyBeanA {

    public ProxyBeanA(){
        log.info("ProxyBeanA + constructor");
    }

    @PostConstruct
    public void init(){
        log.info("ProxyBeanA + PostConstruct");
    }

    public void firstTargetMethod(){
        log.info("ProxyBeanA + firstTargetMethod");
    }
}
