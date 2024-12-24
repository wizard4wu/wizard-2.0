package com.dev.wizard.config;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
public class PostConstructorAnnotaionAspect {
    @Pointcut("execution(@annotation(javax.annotation.PostConstruct)")
    public void postConstructMethods() {}

    @Around("postConstructMethods()")
    public Object handlePostConstructException(org.aspectj.lang.ProceedingJoinPoint joinPoint) throws Throwable {
        try {
            // 执行原始的@PostConstruct方法
            return joinPoint.proceed();
        } catch (Exception e) {
            // 捕获异常并处理
            System.out.println("Exception occurred in @PostConstruct: " + e.getMessage());
            // 这里可以记录日志，或者采取其他处理措施
            // 例如，返回null、设定默认值，或者通知开发者
            return null; // 返回null不会影响容器启动
        }
    }
}
