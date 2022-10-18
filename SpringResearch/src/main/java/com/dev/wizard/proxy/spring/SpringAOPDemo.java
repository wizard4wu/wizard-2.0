package com.dev.wizard.proxy.spring;


import com.google.common.collect.Lists;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * 1.Spring中会将一些高级切面(一个切面有好几种通知)转成低级切面(一个切面只有一种通知)
 * 2.根据低级切面的优先级构建成环绕通知执行 执行采用层层递归的方式
 */
public class SpringAOPDemo {

    public void testMethod(String value){
        System.out.println("SpringAOPDemo + testMethod + " + value);
    }


    public static class MethodFirst implements MethodInterceptor{
        @Nullable
        @Override
        public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
            System.out.println("MethodFirst before ...");
            Object obj = invocation.proceed();
            System.out.println("MethodFirst after ...");
            return obj;
        }
    }

    public static class MethodSecond implements MethodInterceptor{
        @Nullable
        @Override
        public Object invoke(@Nonnull MethodInvocation invocation) throws Throwable {
            System.out.println("MethodSecond before ...");
            Object obj = invocation.proceed();
            System.out.println("MethodSecond after ...");
            return obj;
        }
    }



    public static class MyInvocation implements MethodInvocation{
        private List<MethodInterceptor> methodInterceptorList;
        private Method method;
        private Object target;
        private Object[] args;

        private int counter = 0; //统计方法拦截器调用次数

        public MyInvocation(Object target, Method method, Object[] args, List<MethodInterceptor> methodInterceptorList){
            this.methodInterceptorList = methodInterceptorList;
            this.target = target;
            this.method = method;
            this.args = args;
        }
        public Object proceed() throws Throwable {
            //当一个目标方法有多个通知的时候  目标方法执行一次  多个切面按照优先级先后执行
            if( counter >= methodInterceptorList.size()){
                return method.invoke(target, args);
            }
            Object object = methodInterceptorList.get(counter ++).invoke(this);
            return object;
        }

        @Nonnull
        @Override
        public Method getMethod() {
            return this.method;
        }

        @Nonnull
        @Override
        public Object[] getArguments() {
            return this.args;
        }

        @Nullable
        @Override
        public Object getThis() {
            return target;
        }

        @Nonnull
        @Override
        public AccessibleObject getStaticPart() {
            return method;
        }
    }


    public static void main(String[] args) throws Throwable {

        SpringAOPDemo springAOPDemo = new SpringAOPDemo();

        List<MethodInterceptor> methodInterceptorList = Arrays.asList(new MethodFirst(), new MethodSecond());

        MyInvocation myInvocation = new MyInvocation(springAOPDemo, springAOPDemo.getClass().getMethod("testMethod", String.class), new Object[]{"HHH"}, methodInterceptorList);

        myInvocation.proceed();
    }



}
