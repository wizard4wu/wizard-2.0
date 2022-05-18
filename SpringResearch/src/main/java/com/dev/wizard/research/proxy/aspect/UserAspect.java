package com.dev.wizard.research.proxy.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class UserAspect {

    @Before("execution(public void com.dev.wizard.research.proxy.service.UserService.testProxy())")
    public void userBefore(JoinPoint joinpoint){
        System.out.println("userBefore");
    }
}
