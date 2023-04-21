package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RunnableFuture;

@Slf4j
public class CreateThreadDemo {

    public static class ExtendThread extends Thread{

        public void run(){
            log.info("ExtendThread");
        }
    }

    public static class ImplementRunnableInterface implements Runnable{
        @Override
        public void run() {
            log.info("ImplementRunnableInterface");
        }
    }
    public static class ImplementCallableInterface implements Callable<String>{
        @Override
        public String call() throws Exception {
            log.info("ImplementCallableInterface");
            return "ImplementCallableInterface";
        }
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread extendThread = new ExtendThread();
        extendThread.start();

        Thread thread1 = new Thread(new ImplementRunnableInterface(), "my-thread");
        thread1.start();


        RunnableFuture<String> futureTask = new FutureTask<>(new ImplementCallableInterface());
        Thread thread2 = new Thread(futureTask);
        thread2.start();
        String value = futureTask.get();
        log.info("value: {}", value);

    }
}
