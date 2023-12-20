package com.dev.wizard.juc.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

@Slf4j
public class LockSupportTest {
    public static void main(String[] args) {
        LockSupportTest supportTest = new LockSupportTest();
        supportTest.testLockSupport();
    }
    public void testWaitNotify(){
        Object objectLock = new Object();
        new Thread(() -> {
            synchronized (objectLock){
                log.info("start ......");
                try {
                    objectLock.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                log.info("end ......");
            }
        }).start();
        new Thread(() ->{
            synchronized (objectLock){
                log.info("ready for notify");
                objectLock.notify();
            }
        }).start();
    }

    public void testLockCondition(){
        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(() -> {
            lock.lock();
            log.info("ready wait");
            try {
                condition.await();
                log.info("end");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }finally {
                lock.unlock();
            }
        }).start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        new Thread(() -> {
            lock.lock();
            try {
                log.info("start to signal");
                condition.signal();
                log.info("signal end");
            }finally {
               lock.unlock();
            }
        }).start();
    }

    public void testLockSupport(){
        Thread t1 = new Thread(() ->{
            log.info("park start ...");
            LockSupport.park();
            log.info("park end ...");
        });
        t1.start();

        Thread t2 = new Thread(() ->{
            log.info("unpark start ...");
            LockSupport.unpark(t1);
            log.info("unpark end ...");
        });
        t2.start();
    }
}
