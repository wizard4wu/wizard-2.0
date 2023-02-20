package com.dev.wizard.proxy.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.cglib.core.DebuggingClassWriter;


public class ProxyFactoryDemo {


    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "SpringResearch\\cglib");

        //1.基于切面使用ProxyFactory创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory();
        //2.创建目标对象
        ProxyFactoryDemo.Target target = new ProxyFactoryDemo.Target();
        //3.告诉代理对象为哪个目标对象创建代理
        proxyFactory.setTarget(target);

        //4.获取目标类的接口 可用于JDK代理
        proxyFactory.setInterfaces(target.getClass().getInterfaces());

        //5.选择使用JDK代理还是CGLIB代理
        /**
         * 1. false
         *      a).目标类存在接口，则使用JDK代理；
         *      b).目标类不存在接口，则使用CGLIB代理；
         * 2. true
         *      无论是否实现接口均使用CGLIB代理
         */
        proxyFactory.setProxyTargetClass(Boolean.TRUE);

        //6.构建切面 = 切点 + 通知
        //6.1 构建切点
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(* firstTargetMethod())");

        AspectJExpressionPointcut pointcut2 = new AspectJExpressionPointcut();
        pointcut2.setExpression("execution(* firstTargetMethod())");
        //6.2 构建通知
        MethodInterceptor methodInterceptor = invocation -> {
            System.out.println("Before ....");
            Object obj = invocation.proceed();
            System.out.println("After ....");
            return obj;
        };
        MethodInterceptor methodInterceptor2 = invocation -> {
            System.out.println("Before 2 ....");
            Object obj = invocation.proceed();
            System.out.println("After 2 ....");
            return obj;
        };

        //6.3 形成切面
        Advisor firstAdvisor = new DefaultPointcutAdvisor(pointcut, methodInterceptor);
        Advisor secondAdvisor = new DefaultPointcutAdvisor(pointcut2, methodInterceptor2);
        proxyFactory.addAdvisors(firstAdvisor, secondAdvisor);

        //7. 生成代理对象
        ProxyFactoryDemo.Target proxyObj = (ProxyFactoryDemo.Target)proxyFactory.getProxy();
        proxyObj.firstTargetMethod();
        proxyObj.finalMethod();
    }


    public static class Target {
        public void firstTargetMethod() {
            System.out.println("Target + firstTargetMethod");
        }
        public void secondTargetMethod() {
            System.out.println("Target + secondTargetMethod");
        }
        public void publicMethod(){
            System.out.println("publicMethod...");
        }
        private void privateMethod(){
            System.out.println("privateMethod...");
        }
        public final void finalMethod(){
            System.out.println("finalMethod...");
        }
    }
}
