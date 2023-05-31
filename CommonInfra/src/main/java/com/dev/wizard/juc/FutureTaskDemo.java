package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

@Slf4j
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask<String> futureTaskWithResult = new FutureTask<>(new MyCallable());

        FutureTask futureTaskWithoutResult = new FutureTask(new MyThread(), null);

        Thread thread = new Thread(futureTaskWithResult,"t1");
        thread.start();
        log.info(futureTaskWithResult.get());

        Thread thread2 = new Thread(futureTaskWithoutResult,"t2");
        thread2.start();





    }

    public static class MyThread extends Thread{
        public void run(){
            log.info("MyThread");
        }
    }

    public static class MyRunnable implements Runnable{

        @Override
        public void run() {
            log.info("MyRunable");
        }
    }

    public static class MyCallable implements Callable<String>{

        @Override
        public String call() throws Exception {
            log.info("MyCallable");
            return "MyCallable";
        }
    }

}
