package com.wizard.data.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Interview_2 {
    /***
     * 启动多个线程(比如5个)每个线程循环打印若干相同数量(比如3个)的数字,例如线程1打印1,2,3,
     * 线程2打印4,5,6, 线程3打印7,8,9, 线程4打印10,11,12, 线程5打印13,14,15,
     * 接着再由线程1打印16,17,18….以此类推, 直到打印到100.
     ***/
    private static AtomicInteger numberValue = new AtomicInteger(1);
    int counter = 0;
    private static final int THREAD_NUMBER = 5;
    private volatile static int currentThreadId = 0;
    private static int MAX_VALUE = 100;
    private static final Lock lock = new ReentrantLock();
    private static final Condition[] conditions = new Condition[THREAD_NUMBER];
    public static void main(String[] args) {
        for(int index = 0; index < THREAD_NUMBER; index++){
            conditions[index] = lock.newCondition();
        }
        for(int index = 0; index < THREAD_NUMBER; index++){
            int threadId = index;
            new Thread(() -> {
                while(true) {
                    lock.lock();
                    try {
                        while (threadId != currentThreadId && numberValue.get() <= MAX_VALUE) {
                            try {
                                conditions[threadId].await();
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (numberValue.get() > MAX_VALUE) {
                            //通知其线程
                            conditions[(threadId + 1) % THREAD_NUMBER].signal();
                            break;
                        }
                        for(int j = 0; j < 3 && numberValue.get() <= MAX_VALUE; j++){
                            System.out.println(threadId + ":" + numberValue.getAndIncrement());
                        }
                        //使用下一个线程
                        currentThreadId = (currentThreadId + 1) % THREAD_NUMBER;
                        conditions[currentThreadId].signal();
                    } finally {
                        lock.unlock();
                    }
                }
            }).start();
        }
    }
}
