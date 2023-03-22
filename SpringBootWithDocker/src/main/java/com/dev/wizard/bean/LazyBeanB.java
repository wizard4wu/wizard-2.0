package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Lazy
@Slf4j
public class LazyBeanB {

    @Autowired
    private LazyBeanA lazyBeanA;

    public LazyBeanB(){
        log.info("LazyBeanB + ConstructorWithoutParameter");
    }
}
