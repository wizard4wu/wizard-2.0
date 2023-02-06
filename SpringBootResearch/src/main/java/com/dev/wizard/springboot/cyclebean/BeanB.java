package com.dev.wizard.springboot.cyclebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class BeanB {

    private BeanA beanA;

    private BeanC beanC;


    @Autowired
    public BeanB(BeanA beanA, BeanC beanC){
        this.beanA = beanA;
        this.beanC = beanC;
    }


    public BeanB(){
        log.info("BeanB 构造函数");
    }

    @PostConstruct
    public void init(){
        log.info("BeanB init()");
    }

}
