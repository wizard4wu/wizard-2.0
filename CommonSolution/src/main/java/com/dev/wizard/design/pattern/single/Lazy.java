package com.dev.wizard.design.pattern.single;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Lazy {

    private static Lazy INSTANCE = null;
    private static Lazy INSTANCE2 = null;
    private Lazy() {
        System.out.println("lazy constructor");
    }

    /**
     * 在多线程的情况下需要对该方法加锁实现安全调用
     * 但是加锁只是为了在第一次创建对象的时候发生作用
     * 一旦对象生成后续访问就不需要锁的存在
     * 这时候锁的存在是多余的 并且大大影响性能
     */
//    public static synchronized Lazy getInstance(){
//        if(null == INSTANCE){
//            INSTANCE = new Lazy();
//        }
//        return INSTANCE;
//    }

    /**
     * 双检查锁懒汉式  （DCL Double Check Lock）
     * 降低锁的粒度 提高并发
     * 该种单例模式Instance需要volatile修饰 该关键可以保证可见性和有序性
     * volatile在赋值语句后面加写屏障，保证屏障之前的语句禁上指令重排
     */
    public static Lazy getInstance2() {
        if (null == INSTANCE) {
            synchronized (Lazy.class) {
                if (null == INSTANCE) {
                    INSTANCE = new Lazy();
                }
            }
        }
        return INSTANCE;
    }

    public static Lazy getInstance3() {
        if (null == INSTANCE2) {
            synchronized (Lazy.class) {
                if (null == INSTANCE2) {
                    INSTANCE2 = new Lazy();
                }
            }
        }
        return INSTANCE2;
    }


    public static void main(String[] args)throws Exception {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            executorService.execute(() -> {
                Lazy singleton = Lazy.getInstance2();
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Lazy singleton2 = Lazy.getInstance3();
                System.out.println("Thread " + Thread.currentThread().getName() + " get singleton: " + singleton);
                System.out.println("Thread " + Thread.currentThread().getName() + " get singleton2:          " + singleton2);
            });
        }
        executorService.shutdown();
    }
}
