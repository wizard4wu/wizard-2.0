package com.dev.wizard.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
@Order(Integer.MAX_VALUE - 2)
public class MyAspect {

    @Before("execution (* addUser(*))")
    public void beforeAspectMethod(){
        log.info("MyAspect + beforeAspectMethod");
      //  throw new RuntimeException();
    }
}
