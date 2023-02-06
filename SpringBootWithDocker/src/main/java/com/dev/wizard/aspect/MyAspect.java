package com.dev.wizard.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Slf4j
public class MyAspect {

    private MyAspect(){
        log.info("MyAspect Construct");
    }

    @Before("execution(* firstTargetMethod())")   //生效
    @After("execution(* zeroTargetMethod())")
    public void firstAspect(){
        log.info("MyAspect + firstAspect");
    }

    @After("execution(* firstTargetMethod())")
    public void secondAspect(){
        log.info("MyAspect + secondAspect");
    }

    @After("execution(* zeroTargetMethod())")
    public void thirdAspect(){
        log.info("MyAspect + thirdAspect");
    }

}
