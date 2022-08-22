package com.dev.wizard.proxy.agent;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

@Aspect
public class MyAspect {

    @Before("execution (* com.dev.wizard.proxy.agent.TestService.*()  )")
    public void before(){
        System.out.println("before......");
    }
}
