package com.dev.wizard.springboot.cyclebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class BeanE {
    public BeanE(){
        log.info("BeanE 构造函数");
    }

    @PostConstruct
    public void init(){
        log.info("BeanE init()");
    }

    public void test(){
        System.out.println("BeanE + test()");
    }
}
