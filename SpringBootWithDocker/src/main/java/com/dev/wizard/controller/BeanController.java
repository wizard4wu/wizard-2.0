package com.dev.wizard.controller;

import com.dev.wizard.bean.BeanE;
import com.dev.wizard.bean.BeanF;
import com.dev.wizard.bean.BeanH;
import com.dev.wizard.bean.LazyBeanA;
import com.dev.wizard.bean.MyInterface;
import com.dev.wizard.bean.ProxyBeanA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@RestController
@Slf4j
public class BeanController {

    @Autowired
    private ProxyBeanA proxyBeanA;

    @Autowired
    private MyInterface beanC;

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
    public void test() throws InterruptedException, ExecutionException {
//        proxyBeanA.firstTargetMethod();
//        proxyBeanA.zeroTargetMethod();
//        beanC.firstTargetMethod();
      //  beanE.testInternalClassCall();
      //  beanF.testMethod();
        beanH.method();
        lazyBeanA.testMethod();
//        Future<String> result = beanF.asyncMethod();
//        log.info("test .....");
//        String value = result.get();
//
//        CompletableFuture<String> stringFuture = beanF.asyncMethodByCompletableFuture();
//        stringFuture.get();
//        log.info("value: {}");
    }
}
