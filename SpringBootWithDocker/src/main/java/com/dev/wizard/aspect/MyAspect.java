package com.dev.wizard.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class MyAspect {



    private MyAspect(){
        log.info("MyAspect Construct");
    }

    @After("execution(* zeroTargetMethod())")  //不生效
    @Before("execution(* firstTargetMethod())")   //生效
    public void firstAspect(){
        log.info("MyAspect + firstAspect");
    }

    @Before("execution(* firstTargetMethod())")   //生效
    public void afirstAspect(){
        log.info("MyAspect + afirstAspect");
    }

    @After("execution(* firstTargetMethod())")
    public void secondAspect(){
        log.info("MyAspect + secondAspect");
    }

    @After("execution(* zeroTargetMethod())")
    public void thirdAspect(){
        log.info("MyAspect + thirdAspect");
    }

    @Pointcut("execution(* zeroTargetMethod())")
    public void pointcutMethod(){
        log.info("MyAspect + pointcutMethod");
    }
}
