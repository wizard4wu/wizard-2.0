package com.dev.wizard.bean;

import io.lettuce.core.protocol.AsyncCommand;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Slf4j
@Service
public class BeanF {

    public BeanF(){
        log.info("BeanF Constructor");
    }
    @Lazy
    @Autowired
    private BeanE beanE;



    public void testMethod(){
        log.info("BeaF + testMethod");
    }

    @Async
    public Future<String> asyncMethod() throws InterruptedException {
        log.info("BeanFFFF + asyncMethod");
        Thread.sleep(2000L);
        return new AsyncResult<>("Hello asyncMethod");
    }

    @Async
    public CompletableFuture<String> asyncMethodByCompletableFuture(){
        log.info("BeanF + asyncMethodByCompletableFuture");
        try {
            Thread.sleep(3000L);
        }catch (Exception e){

        }
        return CompletableFuture.completedFuture("Hello CompletableFuture");
    }
}
