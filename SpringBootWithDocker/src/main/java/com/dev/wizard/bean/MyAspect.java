package com.dev.wizard.bean;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {

    @Before("execution(* firstTargetMethod())")
    public void firstAspect(){
        log.info("MyAspect + firstAspect");
    }

    @After("execution(* firstTargetMethod())")
    public void secondAspect(){
        log.info("MyAspect + secondAspect");
    }
}
