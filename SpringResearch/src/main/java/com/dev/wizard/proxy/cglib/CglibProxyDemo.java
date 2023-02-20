package com.dev.wizard.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

import java.time.Instant;
import java.time.temporal.ChronoUnit;

public class CglibProxyDemo {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "SpringResearch\\cglib");

        Target target = new Target();
        /**
         * 1.代理对象本身
         * 2.需要代理的方法
         * 3.代理方法的参数
         * 4.
         * 这里只是生成了一个代理对象，包括该代理对象在执行的情况下的一些逻辑；
         * 另外如果此处的代理对象如果没有执行方法是，是不会执行生成代理对象的。
         */
        Target proxyObject = (Target) Enhancer.create(Target.class, (MethodInterceptor) (proxyObj, method, methodArgs, methodProxy) -> {
            System.out.println("before...");
            //1.使用目标方法通过反射方式执行
            //Object result = method.invoke(target, methodArgs);

            //2.使用代理方法方式调用  底层无反射 spring的选择
            //Object result = methodProxy.invoke(target, methodArgs);

            //3.使用代理方法父类方法  底层无反射
            Object result = methodProxy.invokeSuper(proxyObj, methodArgs);
            System.out.println("after...");

            String returnString = (String) result;
            return returnString + "after Proxy";
        });
        proxyObject.testPrivate();
    }

    //该类被final修饰时时不能生成代理对象的， 会报错
    static class Target {
        //该方法如果被final或者是private修饰的，那么代理对象就无法对该方法实现代理
        public void testPrivate(){
            System.out.println("Target + testPrivate");
        }
    }
}
