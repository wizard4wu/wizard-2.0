package com.dev.wizard.bean;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class ProxyBeanA {

    @Before("execution (* firstTargetMethod())")
    public void firstAspect(){
        System.out.println("firstAspect");
    }

}
