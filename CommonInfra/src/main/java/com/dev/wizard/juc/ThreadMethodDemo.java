package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

@Slf4j
public class ThreadMethodDemo {

    public static void main(String[] args) throws InterruptedException {

        LinkedList<String> list = new LinkedList<>();
        list.add(3,"dd");
        testSleep();
    }
    //线程sleep后可以通过打断的方式来唤醒未到时间的线程
    public static void testSleep() throws InterruptedException {
        Runnable runnable = () ->{
           log.info("sleep method");
            try {
                Thread.sleep(3000L);

                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                log.info("InterruptedException");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
        thread.setPriority(2);
        Thread.sleep(1000L);
        thread.interrupt();
    }
}
