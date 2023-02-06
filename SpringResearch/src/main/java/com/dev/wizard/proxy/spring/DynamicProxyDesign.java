package com.dev.wizard.proxy.spring;

import org.springframework.lang.Nullable;

import javax.annotation.Nonnull;
import java.lang.reflect.Method;
import java.util.List;


public class DynamicProxyDesign {

    public void testMethod(){
        System.out.println("DynamicProxyDesign + testMethod");
    }


    interface MyInterceptor{
        Object invoke(@Nonnull MyInvocation myInvocation);
    }

    interface MyInvocation{
        Object proceed();
    }

    public static class MethodBeforeInterceptor implements MyInterceptor{

        @Override
        public Object invoke(@Nonnull MyInvocation myInvocation) {
            System.out.println("MethodBeforeInterceptor before ... " + myInvocation);
            return myInvocation.proceed();
        }
    }

    public static class MethodAfterInterceptor implements MyInterceptor{

        @Override
        public Object invoke(@Nonnull MyInvocation myInvocation) {
            Object obj = myInvocation.proceed();
            System.out.println("MethodAfterInterceptor after ... " + myInvocation);
            return obj;
        }
    }



    public static class ProxyInvocation implements MyInvocation{
        private final Object proxy;

        private final Object target;

        private final Method method;

        private Object[] arguments;

        private final Class<?> targetClass;

        private final List<MyInterceptor> myInterceptorList;

        private int index = 0;

        public ProxyInvocation(Object proxy, @Nullable Object target, Method method,
                                     Object[] arguments, @Nullable Class<?> targetClass,
                                     List<MyInterceptor> myInterceptorList){
            this.proxy = proxy;
            this.target = target;
            this.method = method;
            this.arguments = arguments;
            this.targetClass = targetClass;
            this.myInterceptorList = myInterceptorList;
        }

        @Override
        public Object proceed() {

            int size = myInterceptorList.size();

            if(0 == size || index == size){
                try {
                    //执行目标方法
                    return this.method.invoke(target);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
            MyInterceptor myInterceptor = this.myInterceptorList.get(index ++);
            return myInterceptor.invoke(this);
        }
    }

    public static void main(String[] args) throws NoSuchMethodException {

        List<MyInterceptor> myInterceptorList = List.of(new MethodAfterInterceptor(), new MethodBeforeInterceptor());

        DynamicProxyDesign target = new DynamicProxyDesign();
        ProxyInvocation proxyInvocation = new ProxyInvocation(
                null,
                target,
                target.getClass().getDeclaredMethod("testMethod", null),
                null,
                target.getClass(),
                myInterceptorList);
        proxyInvocation.proceed();
    }
}
