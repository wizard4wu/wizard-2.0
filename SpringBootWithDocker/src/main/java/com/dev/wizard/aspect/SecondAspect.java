package com.dev.wizard.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Aspect
@Component
@Slf4j
public class SecondAspect {

    private SecondAspect(){
        log.info("SecondAspect + Construct");
    }

    @After("execution(* targetMethod())")
    public void secondAspectMethod(){
        log.info("SecondAspect + secondAspectMethod");
    }
}
