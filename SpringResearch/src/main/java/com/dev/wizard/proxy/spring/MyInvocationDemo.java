package com.dev.wizard.proxy.spring;

import org.aopalliance.intercept.MethodInterceptor;
import org.springframework.aop.framework.ReflectiveMethodInvocation;

import java.lang.reflect.Method;
import java.util.List;

public class MyInvocationDemo extends ReflectiveMethodInvocation {


    private int index;
    protected MyInvocationDemo(Object proxy, Object target, Method method, Object[] arguments, Class<?> targetClass, List<Object> interceptorsAndDynamicMethodMatchers) {
        super(proxy, target, method, arguments, targetClass, interceptorsAndDynamicMethodMatchers);
    }

    public static void main(String[] args) throws Throwable {

        MyInvocationDemo.Target target = new MyInvocationDemo.Target();

        MethodInterceptor methodInterceptor1 = invocation -> {
            System.out.println("Before 1 ....");
            Object obj = invocation.proceed();
            System.out.println("After 1 ....");
            return obj;
        };
        MethodInterceptor methodInterceptor2 = invocation -> {
            System.out.println("Before 2 ....");
            Object obj = invocation.proceed();
            System.out.println("After 2 ....");
            return obj;
        };

        //构建通知的执行链
        List<Object> methodInterceptorList = List.of(methodInterceptor1, methodInterceptor2);

        Method method = target.getClass().getDeclaredMethod("testMethod", null);
        MyInvocationDemo myInvocationDemo = new MyInvocationDemo(null, target, method, null, target.getClass(), methodInterceptorList);
        myInvocationDemo.proceed();
    }

    @Override
    public Object proceed() throws Throwable {
        int size = this.interceptorsAndDynamicMethodMatchers.size();
        //如果没有切面(size=0)或者前面执行完了 就得执行连接点方法（目标类方法）
        if(index == size){
            //此处简陋点 就用反射直接执行 无伤大雅
           return this.method.invoke(target, arguments);
        }
        MethodInterceptor methodInterceptor = (MethodInterceptor)this.interceptorsAndDynamicMethodMatchers.get(index ++);
        //执行切面增强逻辑 同时得把这个执行链对象传递下去
        return methodInterceptor.invoke(this);
    }

    public static class Target {
        public void testMethod(){
            System.out.println("target + testMethod...");
        }
    }
}