package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BeanB {

    @Autowired
    private BeanC beanC;

    @Lazy
    public BeanB(){
        log.info("Constructor + BeanB");
    }
}
