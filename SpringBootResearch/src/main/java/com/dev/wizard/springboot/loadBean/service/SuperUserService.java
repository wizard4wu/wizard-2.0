package com.dev.wizard.springboot.loadBean.service;

import com.dev.wizard.springboot.loadBean.custom.CustomAnno;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class SuperUserService {
    @CustomAnno("hello")
    private String value;

    @PostConstruct
    public void init(){
        System.out.println("我是SuperUserService的PostConstruct");
    }

    public SuperUserService(){
        System.out.println("我是SuperUserService");
    }
}
