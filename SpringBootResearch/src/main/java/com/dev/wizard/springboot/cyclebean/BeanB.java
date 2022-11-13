package com.dev.wizard.springboot.cyclebean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
@Slf4j
public class BeanB {

    @Autowired
    private SecondHandler myHandlerList;

    @Autowired
    private BeanE beanE;



    public BeanB(){
        log.info("BeanB 构造函数");
    }

    @PostConstruct
    public void init(){
        log.info("BeanB init()");
    }

    public void test(){
        beanE.test();
        System.out.println("BeanB + test");
    }
}
