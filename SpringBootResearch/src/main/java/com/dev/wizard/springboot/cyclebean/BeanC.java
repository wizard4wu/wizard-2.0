package com.dev.wizard.springboot.cyclebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
public class BeanC{

    @Autowired
    private BeanB beanB;


    public BeanC(){
        log.info("BeanC 构造函数");
    }

    @PostConstruct
    public void init(){
        log.info("BeanC init()");
    }
    @TestAnno
    public void test(){
        beanB.test();
    }
}
