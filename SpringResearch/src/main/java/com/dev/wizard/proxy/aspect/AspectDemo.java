package com.dev.wizard.proxy.aspect;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AspectDemo {
    public static class FirstTarget{
        public void firstTargetMethod(){
            System.out.println("FirstTarget###firstTargetMethod");
        }
    }

    public static class SecondTarget{
        public void secondTargetMethod(){
            System.out.println("SecondTarget###secondTargetMethod");
        }
    }
    @Aspect
    public static class MyAspect{
        @Before("execution (* firstTargetMethod())")
        public void before(){
            System.out.println("before。。。");
        }

        @After("execution (* firstTargetMethod()))")
        public void after(){
            System.out.println("after。。。");
        }
    }
    @Configuration
    public static class Config{
        @Bean
        public Advisor myAdvisor(MethodInterceptor methodInterceptor){
            AspectJExpressionPointcut expressionPointcut = new AspectJExpressionPointcut();
            expressionPointcut.setExpression("execution (* firstTargetMethod())");
            return new DefaultPointcutAdvisor( expressionPointcut, methodInterceptor);
        }

        @Bean
        public MethodInterceptor methodInterceptor(){
           return new MethodInterceptor(){
                @Nullable
                @Override
                public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
                    System.out.println("before---");
                    Object obj = invocation.proceed();
                    System.out.println("after---");
                    return obj;
                }
            };
        }
    }
}
