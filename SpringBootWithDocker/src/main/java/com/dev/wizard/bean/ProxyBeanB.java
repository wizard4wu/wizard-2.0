package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ProxyBeanB {

    private ProxyBeanA proxyBeanA;

    public ProxyBeanB(){
        log.info("ProxyBeanB + constructor");
    }

    public void firstTargetMethod(){
        log.info("ProxyBeanB + firstTargetMethod");
    }

    public String firstTargetMethod(String value, int number){
        log.info("ProxyBeanB + firstTargetMethod");
        return value + number;
    }
    public String firstTargetMethod(String value){
        log.info("ProxyBeanB + firstTargetMethod");
        return value;
    }
}
