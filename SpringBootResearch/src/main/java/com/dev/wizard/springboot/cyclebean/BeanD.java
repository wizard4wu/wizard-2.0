package com.dev.wizard.springboot.cyclebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class BeanD {

    public BeanD(){
        log.info("BeanD 构造函数");
    }

    @PostConstruct
    public void init(){
        log.info("BeanD init()");
    }


    public void testMethodBeanD(){
        log.info("BeanD testMethodBeanD");
    }
}
