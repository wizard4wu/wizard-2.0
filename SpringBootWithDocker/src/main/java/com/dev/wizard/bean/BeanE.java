package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class BeanE {
    @Autowired
    private ApplicationContext applicationContext;

    public void testInternalClassCall(){
        log.info("BeanE + testInternalClassCall");
        BeanE beanE = applicationContext.getBean(BeanE.class);
        beanE.asyncMethod();
    }
    @Async
    public void asyncMethod(){
        log.info("BeanE + asyncMethod");
    }
}
