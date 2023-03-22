package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

@Service
@Slf4j
@Order(5)
public class BeanC implements MyInterface{
    @Autowired
    private BeanB beanB;

    public BeanC(){
        Method[] methods = ReflectionUtils.getAllDeclaredMethods(BeanC.class);


        //Modifier.isFinal(methods[0].getModifiers()) || Modifier.isPrivate(methods[0].getModifiers());
        log.info("Constructor + BeanC");
    }

    public void firstTargetMethod(){
        log.info("BeaC + firstTargetMethod");
    }

    @Override
    public void myInterfaceMethod() {
        log.info("BeanC + myInterfaceMethod");
    }
}
