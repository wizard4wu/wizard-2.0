package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeanG {

    public BeanG(){
        log.info("constructor");
    }
    @Autowired
    private BeanH beanH;

    public BeanG(BeanH beanH){
       log.info("constructor + BeanG");
    }

    public final void method(){
        log.info("BeanG + method");
    }
}
