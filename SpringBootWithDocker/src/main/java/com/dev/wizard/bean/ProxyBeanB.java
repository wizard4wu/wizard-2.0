package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProxyBeanB {
    @Autowired
    private ProxyBeanA proxyBeanA;

    public ProxyBeanB(){
        log.info("ProxyBeanB + constructor");
    }

    public void firstTargetMethod(){
        log.info("ProxyBeanB + firstTargetMethod");
    }
}
