package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CountDownLatchDemo {

    //CountDownLatch采用了CAS的方式保证了多线程并发时减一操作
    //是线程安全的
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(10);
        countDownLatch.countDown();
        ExecutorService threadPoolExecutor = Executors.newFixedThreadPool(10);
        threadPoolExecutor.submit(() -> {
            return "hhe";
        });
        for (int i = 0; i < 10; i++) {
            threadPoolExecutor.execute(() -> {
                try {
                    log.info("threadPoolExecutor");
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    countDownLatch.countDown();
                }
            });
        }
        log.info("start to wait");
        countDownLatch.await();
        log.info("finish the wait");
        threadPoolExecutor.shutdown();
    }

}
