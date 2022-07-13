package com.dev.wizard.springboot.loadBean.service;

import com.dev.wizard.springboot.loadBean.custom.CustomAnno;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Component
public class UserService {

    @Autowired
    private OrderService orderService;

    @CustomAnno("hello")
    private String value;

    @PostConstruct
    public void init(){
        System.out.println("我是UserService的PostConstruct");
    }

    public UserService(){
        System.out.println("我是UserService");
    }


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
       // System.out.println("UserService ------ postProcessBeforeInitialization<前置>" + beanName);
        if("orderService".equals(beanName)){
            System.out.println("OrderService ------ postProcessBeforeInitialization<前置>" + beanName);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
       // System.out.println("UserService ------ postProcessAfterInitialization<后置>" + beanName);
        if("orderService".equals(beanName)){
            System.out.println("OrderService ------ postProcessAfterInitialization<后置>" + beanName);
        }
        return bean;
    }
}
