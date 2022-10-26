package com.dev.wizard.springboot.event.listen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Spring 的Event默认是同步的；
 *
 * 异步设置方式：
 * 1. SimpleApplicationEventMulticaster中的taskExecutor变成异步执行，这一设置会导致所有的事件均为异步执行
 * 2. 在相应的方法上加@Async注解  并且在应用配置上加@EnableAsync
 */

@Configuration
public class SpringEventConfig {


    @Bean
    public SimpleAsyncTaskExecutor simpleAsyncTaskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }


    @Bean
    public Executor executor(){
     ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 30, TimeUnit.SECONDS, new LinkedBlockingQueue<>(10));
     return executor;
    }

    @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster(Executor executor) {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        simpleApplicationEventMulticaster.setTaskExecutor(executor);
        return simpleApplicationEventMulticaster;
    }
}
