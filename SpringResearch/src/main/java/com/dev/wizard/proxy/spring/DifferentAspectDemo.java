package com.dev.wizard.proxy.spring;

import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ConfigurationClassPostProcessor;
import org.springframework.context.support.GenericApplicationContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * 切面类分为两种：1.Advisor  <--- 低级切面：一个切面只能有一种通知
 * 2.Aspect   <--- 高级切面：一个切面可以同时存在多种通知
 */
public class DifferentAspectDemo {

    public static void main(String[] args) {
        GenericApplicationContext applicationContext = new GenericApplicationContext();
        applicationContext.registerBean("aspectClass", AspectClass.class);
        applicationContext.registerBean("config", Config.class);
        applicationContext.registerBean(ConfigurationClassPostProcessor.class);
        applicationContext.refresh();

        for (String name : applicationContext.getBeanDefinitionNames()) {
            System.out.println(name);
        }
    }
    @Aspect
    static class AspectClass {
        @Before("@execution(* targetFirstMethod())")
        public void before() {
            System.out.println("before...");
        }

        @After("@execution(* targetFirstMethod())")
        public void after() {
            System.out.println("after ...");
        }
    }

    static class TargetFirst {
        public void targetFirstMethod() {
            System.out.println("targetFirstMethod");
        }
    }

    static class TargetSecond {
        public void targetSecondMethod() {
            System.out.println("targetSecondMethod");
        }
    }

    @Configuration
    static class Config {

        @Bean
        public Advisor advisor(Advice myAdvice) {
            AspectJExpressionPointcut expressionPointcut = new AspectJExpressionPointcut();
            expressionPointcut.setExpression("* targetSecondMethod()");
            return new DefaultPointcutAdvisor(expressionPointcut, myAdvice);
        }

        @Bean
        public MethodInterceptor myAdvice() {
            return  invocation -> {
                    System.out.println("A + before ...");
                    Object result = invocation.proceed();
                    System.out.println("A + after ...");
                    return result;
                };
        }
    }

}
