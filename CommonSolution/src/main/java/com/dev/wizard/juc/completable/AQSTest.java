package com.dev.wizard.juc.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class AQSTest {

    public static void main(String[] args) {


        AQSTest aqsTest = new AQSTest();
        aqsTest.testReentrantLock();
    }

    public void testReentrantLock(){
        Lock lock = new ReentrantLock();
        Thread t1 = new Thread(() ->{
            lock.lock();
            try {
                log.info("t1 start to execute ...");
            }finally {
                lock.unlock();
            }
        });
        Thread t2 = new Thread(() ->{
            lock.lock();
            try {
                log.info("t2 start to execute ...");
            }finally {
                lock.unlock();
            }
        });
        t1.start();
        t2.start();
    }
}
