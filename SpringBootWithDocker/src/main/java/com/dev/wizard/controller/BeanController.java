package com.dev.wizard.controller;

import com.dev.wizard.bean.BeanE;
import com.dev.wizard.bean.BeanF;
import com.dev.wizard.bean.BeanH;
import com.dev.wizard.bean.LazyBeanA;
import com.dev.wizard.bean.MyInterface;
import com.dev.wizard.bean.ProxyBeanA;
import com.dev.wizard.bean.ProxyBeanB;
import lombok.extern.slf4j.Slf4j;
import org.springframework.aop.framework.AopProxyUtils;
import org.springframework.asm.Type;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Signature;
import org.springframework.cglib.core.TypeUtils;
import org.springframework.cglib.proxy.Callback;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;
import java.lang.reflect.Method;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class BeanController {

    @Autowired
    private MyInterface proxyBeanA;

    @Autowired
    private ProxyBeanB proxyBeanB;

    @Autowired
    private BeanF beanF;

    @Autowired
    private BeanE beanE;

    @Autowired
    private BeanH beanH;

    @Autowired
    @Lazy
    private LazyBeanA lazyBeanA;

    @RequestMapping("/test")
    public void test() throws Throwable {


        Signature signature = new Signature("firstTargetMethod", Type.getType(String.class), new Type[]{Type.getType(String.class), Type.getType(int.class)});

        Method method = proxyBeanB.getClass().getMethod("CGLIB$findMethodProxy", Signature.class);
        MethodProxy methodProxy = (MethodProxy) method.invoke(proxyBeanB, signature);
        methodProxy.invoke(proxyBeanB, new Object[]{"eh", 3});


        Method method1 = MyInterface.class.getMethod("firstTargetMethod", null);

        Method method2 = proxyBeanA.getClass().getMethod("firstTargetMethod", null);


        method1.invoke(proxyBeanA, null);

        //MethodType methodType = MethodType.methodType(void.class, null);
//        MethodHandle interfaceMethodHandle = MethodHandles.publicLookup().findVirtual(MyInterface.class, "", methodType);
//        interfaceMethodHandle.
//        proxyBeanA.getClass().getMethod("proxyClassLookup");


        // Object object = AopProxyUtils.getSingletonTarget(proxyBeanA);
//        proxyBeanA.firstTargetMethod();
//        proxyBeanB.firstTargetMethod();
//       // proxyBeanA.zeroTargetMethod();
////        beanC.firstTargetMethod();
//      //  beanE.testInternalClassCall();
//      //  beanF.testMethod();
//        beanH.method();
//        lazyBeanA.testMethod();


//        Future<String> result = beanF.asyncMethod();
//        log.info("test .....");
//        String value = result.get();
//
//        CompletableFuture<String> stringFuture = beanF.asyncMethodByCompletableFuture();
//        stringFuture.get();
//        log.info("value: {}");
    }
}
