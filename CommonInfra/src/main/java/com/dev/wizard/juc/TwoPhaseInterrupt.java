package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwoPhaseInterrupt {

    public static void main(String[] args) throws InterruptedException {
        //睡眠中的线程被打断后会抛出异常 并且打断标志位不变；
        //运行中的线程打断后  打断标志位改变 但是继续保持运行但是可以根据标志来终止
       InterruptObject object = new InterruptObject();
       object.start();
       Thread.sleep(5000L);
       object.stop();
    }

    public static class InterruptObject{
        private Thread monitor;

        //启动线程监控
        public void start(){
           monitor = new Thread(() -> {

               boolean interrupt = Thread.currentThread().isInterrupted();
               while(true){
                   log.info("start to monitor");
                   if(interrupt) {
                      break;
                   }
                   try {
                       Thread.sleep(2000L);
                   } catch (InterruptedException e) {
                       log.info("interrupt during sleep");
                       interrupt = true;
                   }
               }

            }, "AAA");
           monitor.start();
        }

        public void stop(){
            log.info("stop the thread");
            monitor.interrupt();
        }

    }
}
