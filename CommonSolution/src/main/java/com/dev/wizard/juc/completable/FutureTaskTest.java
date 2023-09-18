package com.dev.wizard.juc.completable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        MyCallable my = new MyCallable();
        FutureTask<String> future = new FutureTask<>(my);

//        Thread thread = new Thread(future);
//        thread.start();
//        System.out.println(future.get());


        //线程池的方式：
        ExecutorService poolExecutor = Executors.newFixedThreadPool(3);
        poolExecutor.submit(future);
        future.get(3, TimeUnit.HOURS);
        System.out.println(future.get());

    }

    static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            return "hello world";
        }
    }
}
