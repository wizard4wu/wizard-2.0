package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DeadLockDemo {

    public static void main(String[] args) {
        DeadLock deadLock1 = new DeadLock();
        DeadLock deadLock2 = new DeadLock();

        new Thread(() -> {
            synchronized (deadLock1){
                log.info("deadLock1");
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (deadLock2){
                    log.info("deadLock2");
                }
            }

        }, "AAA").start();

        new Thread(() ->{
            synchronized (deadLock2){
                log.info("deadLock2");

                synchronized (deadLock1){
                    log.info("deadLock1");
                }
            }
        }, "BBB").start();
    }

    public static class DeadLock{

        public synchronized void firstMethod(DeadLock deadLock)  {
            log.info("firstMethod");
            try {
                Thread.sleep(1500L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }


        }

        public synchronized void secondMethod() {
            log.info("secondMethod");
        }


    }
}
