package com.dev.wizard.springboot.cyclebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
//避坑循环依赖 从此做起
@Service
@Slf4j
public class BeanA {

//    @Autowired
      private BeanE beanE;
//
//    @Autowired
      private BeanB beanB;


    @Autowired
    public BeanA(BeanE beanE, @Lazy BeanB beanB){
        this.beanE = beanE;
        this.beanB = beanB;
    }

    public void test(){
        beanE.test();
        System.out.println("BeanB + test");
    }

    @PostConstruct
    public void init(){
        log.info("BeanA init()");
    }
}
