package com.dev.wizard.springboot.loadBean.service;

import com.dev.wizard.springboot.loadBean.custom.CustomAnno;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class OrderService  {

    @Autowired
    private UserService userService;

    @Autowired
    private SuperUserService superUserService;

    @CustomAnno("hello")
    private String value;


    @PostConstruct
    public void init(){
        System.out.println("我是OrderService的PostConstruct");
    }

    public OrderService(){
        System.out.println("我是OrderService");
    }

    public String retriveValue(){
        return value;
    }

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        System.out.println("实例化前" + beanName);
        return null;
    }


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if("orderService".equals(beanName)){
         System.out.println("OrderService ------ postProcessBeforeInitialization<前置>" + beanName);
        }

        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if("orderService".equals(beanName)){
            System.out.println("OrderService ------ postProcessAfterInitialization<后置>" + beanName);
        }
       // System.out.println("OrderService============================" + value);
        return bean;
    }
}
