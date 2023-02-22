package com.dev.wizard.proxy.spring;

import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Before;
import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectInstanceFactory;
import org.springframework.aop.aspectj.AspectJAfterReturningAdvice;
import org.springframework.aop.aspectj.AspectJAroundAdvice;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.aspectj.AspectJMethodBeforeAdvice;
import org.springframework.aop.aspectj.SingletonAspectInstanceFactory;
import org.springframework.aop.framework.ProxyFactory;
import org.springframework.aop.framework.ReflectiveMethodInvocation;
import org.springframework.aop.interceptor.ExposeInvocationInterceptor;
import org.springframework.aop.support.DefaultPointcutAdvisor;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * * 切面类分为两种：1.Advisor  <--- 低级切面：一个切面只能有一种通知
 * * 2.Aspect   <--- 高级切面：一个切面可以同时存在多种通知
 * before 和 afterReturn非环绕通知，要对其进行转成环绕通知 即实现MethodInterceptor这种
 * 在解析Before注解时生成的通知是AspectJMethodBeforeAdvice
 * 在真正执行的时候是通过MethodBeforeAdviceAdapter将 MethodBeforeAdvice转成MethodInterceptor
 * <p>
 * 生成代理对象前：高级切面转低级切面
 * 代理对象执行时： 通知转成环绕通知（MethodInterceptor） 已经是环绕通知不用转了
 * 调用链：
 */
public class AspectTransferDemo extends ReflectiveMethodInvocation{
    /**
     * Construct a new ReflectiveMethodInvocation with the given arguments.
     *
     * @param proxy                                the proxy object that the invocation was made on
     * @param target                               the target object to invoke
     * @param method                               the method to invoke
     * @param arguments                            the arguments to invoke the method with
     * @param targetClass                          the target class, for MethodMatcher invocations
     * @param interceptorsAndDynamicMethodMatchers interceptors that should be applied,
     *                                             along with any InterceptorAndDynamicMethodMatchers that need evaluation at runtime.
     *                                             MethodMatchers included in this struct must already have been found to have matched
     *                                             as far as was possibly statically. Passing an array might be about 10% faster,
     *                                             but would complicate the code. And it would work only for static pointcuts.
     */
    protected AspectTransferDemo(Object proxy, Object target, Method method, Object[] arguments, Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {
        super(proxy, target, method, arguments, targetClass, interceptorsAndDynamicMethodMatchers);
    }

    public static void main(String[] args) throws Throwable {
        List<Advisor> advisorList = new ArrayList<>();
        AspectInstanceFactory aspectInstanceFactory = new SingletonAspectInstanceFactory(new MyAspect());
        Method[] methods = MyAspect.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)) {

                //获取注解上的切点表达式
                String executionString = method.getAnnotation(Before.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(executionString);

                //设置通知
                AspectJMethodBeforeAdvice beforeAdvice = new AspectJMethodBeforeAdvice(method, pointcut, aspectInstanceFactory);

                //切点加通知形成切面
                Advisor advisor = new DefaultPointcutAdvisor(pointcut, beforeAdvice);
                advisorList.add(advisor);
            } else if (method.isAnnotationPresent(AfterReturning.class)) {
                String executionString = method.getAnnotation(AfterReturning.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(executionString);
                //设置通知
                AspectJAfterReturningAdvice afterReturningAdvice = new AspectJAfterReturningAdvice(method, pointcut, aspectInstanceFactory);

                //切点加通知形成切面
                Advisor advisor = new DefaultPointcutAdvisor(pointcut, afterReturningAdvice);
                advisorList.add(advisor);

            } else if (method.isAnnotationPresent(Around.class)) {
                String executionString = method.getAnnotation(Around.class).value();
                AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
                pointcut.setExpression(executionString);
                //设置通知
                AspectJAroundAdvice aroundAdvice = new AspectJAroundAdvice(method, pointcut, aspectInstanceFactory);

                //切点加通知形成切面
                Advisor advisor = new DefaultPointcutAdvisor(pointcut, aroundAdvice);
                advisorList.add(advisor);
            }
        }

        for (Advisor advisor : advisorList) {
            System.out.println(advisor);
        }


        //基于切面使用ProxyFactory创建代理对象
        ProxyFactory proxyFactory = new ProxyFactory();
        Target target = new Target();
        proxyFactory.setTarget(target);
        proxyFactory.setInterfaces(TargetInterface.class);
        //将调用链MethodInvocation放入当前线程
        proxyFactory.addAdvice(ExposeInvocationInterceptor.INSTANCE);
        proxyFactory.addAdvisors(advisorList);

        Method firstTargetMethod = Target.class.getMethod("firstTargetMethod");
        //使用Before 和 AfterReturn获取到环绕通知集合是在生成代理后去实现的
        List<Object> list = proxyFactory.getInterceptorsAndDynamicInterceptionAdvice(firstTargetMethod, Target.class);

        System.out.println("-------------------------------");
        for (Object o : list) {
            System.out.println(o);
        }

        System.out.println("-----------分割线--------------------");
        MethodInvocation methodInvocation = new AspectTransferDemo(null, target, firstTargetMethod, new Object[0], target.getClass(), list);
        methodInvocation.proceed();
    }

    public static class MyAspect {
        @Before("execution(* firstTargetMethod())")
        public void firstAdvice() {
            System.out.println("firstAdvice()");
        }

        @AfterReturning("execution(* firstTargetMethod())")
        public void secondAdvice() {
            System.out.println("secondAdvice()");
        }

        //@Around("execution(* firstTargetMethod())")
        public void aroundAdvice() {
            System.out.println("aroundAdvice()");
        }
    }

    public static class Target implements TargetInterface{
        public void firstTargetMethod() {
            System.out.println("Target + firstTargetMethod");
        }
    }

    public interface TargetInterface{
        void firstTargetMethod();
    }
}
