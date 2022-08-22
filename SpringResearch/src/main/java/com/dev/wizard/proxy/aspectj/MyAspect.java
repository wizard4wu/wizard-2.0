package com.dev.wizard.proxy.aspectj;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class MyAspect {

    @Before("execution (* com.dev.wizard.proxy.aspectj.TestService.testService())")
    public void before(){
        System.out.println("before......");
    }
}
