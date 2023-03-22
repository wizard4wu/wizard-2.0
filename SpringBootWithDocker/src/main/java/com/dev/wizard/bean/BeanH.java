package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BeanH {

    @Autowired
    @Lazy
    private BeanG beanG;

    public BeanH(@Lazy BeanG beanG){
        log.info("constructor + BeanH");
    }
    public void method(){
       beanG.method();
    }
}
