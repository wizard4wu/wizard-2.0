package com.dev.wizard.proxy.spring;


import org.aopalliance.intercept.MethodInterceptor;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.PointcutAdvisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.cglib.core.DebuggingClassWriter;

import java.io.IOException;

public class SelectProxyInSpring {

    /**
     * 1.声明切面
     * 2.设置通知，通知包括调用前通知，调用后通知
     * 3.定义切点：需要把通知在某个地方被调用
     * 4.形成代理对象
     */
    @Aspect
    static class MyAspect{

        @Before("execution(* testMethod())")
        public void before(){
            System.out.println("before");
        }

        @After("execution(* testMethod())")
        public void after(){
            System.out.println("after");
        }
    }
    public void testMethod(){
        System.out.println("testMethod");
    }
    //advisor 切面是更细粒度的切面， 包含一个通知和切点
    public static void main(String[] args) throws IOException {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "D:\\temp");

        //1.准备切点：找到需要执行增强的方法
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* testMethod())");

        //2.配置通知：增强的内容
        MethodInterceptor interceptor = invocation -> {
            System.out.println("before...");
            Object result = invocation.proceed();
            System.out.println("after...");
            return result;
        };
        //3.组合切点和通知形成切面
        PointcutAdvisor advisor = new DefaultPointcutAdvisor( pointcut, interceptor);

        //4.形成代理
        /**
         * 1. proxyTargetClass: false
         *                    1.1 目标类实现了接口则使用JDK代理；
         *                    1.2 目标类没有实现接口则使用Cglib代理；
         * 2. proxyTargetClass: true使用的是Cglib代理；
         */
        TargetClass targetClass = new TargetClass();
        ProxyFactory proxyFactory = new ProxyFactory();

        proxyFactory.setTarget(targetClass);
        proxyFactory.addAdvisor(advisor);
        proxyFactory.setProxyTargetClass(false);
        proxyFactory.setInterfaces(targetClass.getClass().getInterfaces());
        TestInterface testInterface = (TestInterface) proxyFactory.getProxy();
        System.out.println(testInterface.getClass());
        testInterface.testMethod();
        testInterface.testMethodWithPara("hello");
    }
    //com.dev.wizard.proxy.spring.SelectProxyInSpring$TargetClass$$EnhancerBySpringCGLIB$$6b9c354f

    interface TestInterface{
        void testMethod();

        void testMethodWithPara(String para);
    }
    static class TargetClass implements TestInterface{
        @Override
        public void testMethod() {
            System.out.println("TargetClass + testMethod");
        }

        @Override
        public void testMethodWithPara(String para) {
            System.out.println("TargetClass + testMethodWithPara" + para);
        }
    }
}
