package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class BeanB {
    public BeanB(){
        log.info("Constructor + BeanB");
    }

    public void init(){
        log.info("init + BeanA");
    }

}
