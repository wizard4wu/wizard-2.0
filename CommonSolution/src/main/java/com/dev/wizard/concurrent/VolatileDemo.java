package com.dev.wizard.concurrent;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class VolatileDemo {

    //JIT  Java即时编译器 对于热点字节码进行优化， 对于读取flag超多阈值次数依旧是同一个值时，
    //我就认为你就是那个值，导致后期更改了还是之前那个值，所以下面sleep要就久一点让其读取flag超多一定的阈值
    //-Xint 设置 jvm 以解释模式运行，所有的字节码将被直接执行，而不会编译成本地码。
    //JIT 不对volatile的变量进行优化
    static volatile boolean flag = false;
    public static void main(String[] args) {

        new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            flag = true;
            log.info("set flag finish");
        }, "thread-1").start();

        test();

    }
    static void test(){
        int i = 0;
        while (!flag){
            i++;
        }
        log.info("test, {}", i);
    }
}
