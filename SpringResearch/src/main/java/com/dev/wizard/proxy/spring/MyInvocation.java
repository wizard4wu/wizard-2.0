package com.dev.wizard.proxy.spring;





import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.List;

public class MyInvocation implements MethodInvocation {

    private final Object targetObject;

    private final Method method;

    private final List<MethodInterceptor> methodInterceptorList;

    private final Object[] arguments;


    public MyInvocation(Object targetObject, Method method, List<MethodInterceptor> methodInterceptorList, Object[] arguments) {
        this.targetObject = targetObject;
        this.method = method;
        this.methodInterceptorList = methodInterceptorList;
        this.arguments = arguments;
    }


    public static void main(String[] args) throws Throwable {


        //构建目标类的对象
        TargetClass targetClass = new TargetClass();
        //构建目标方法
        Method targetMethod = targetClass.getClass().getMethod("targetMethod", null);
        //构建通知List
        MethodInterceptor methodInterceptor1 = invocation -> {
            System.out.println("before 1 ...");
            Object obj = invocation.proceed();
            System.out.println("after 1 ...");
            return obj;
        };
        MethodInterceptor methodInterceptor2 = invocation -> {
            System.out.println("before 2 ...");
            Object obj = invocation.proceed();
            System.out.println("after 2 ...");
            return obj;
        };
        List<MethodInterceptor> methodInterceptors = List.of(methodInterceptor1, methodInterceptor2);

        MyInvocation myInvocation = new MyInvocation(targetClass, targetMethod, methodInterceptors, null);

        myInvocation.proceed();
    }

    @Nonnull
    @Override
    public Method getMethod() {
        return null;
    }

    @Nonnull
    @Override
    public Object[] getArguments() {
        return new Object[0];
    }

    private int index;
    @Nullable
    @Override
    public Object proceed() throws Throwable {
        int size = this.methodInterceptorList.size();
        if(index == size){
            return this.method.invoke(this.targetObject, null);
        }
        MethodInterceptor methodInterceptor = this.methodInterceptorList.get(index ++);
        return methodInterceptor.invoke(this);
    }

    @Nullable
    @Override
    public Object getThis() {
        return null;
    }

    @Nonnull
    @Override
    public AccessibleObject getStaticPart() {
        return null;
    }


    public static class TargetClass {
        public void targetMethod() {
            System.out.println("TargetClass + targetMethod");
        }
    }
}
