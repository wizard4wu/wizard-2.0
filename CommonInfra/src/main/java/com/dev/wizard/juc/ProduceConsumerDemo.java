package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;

@Slf4j
public class ProduceConsumerDemo {

    private LinkedList<String> linkedList = new LinkedList<>();
    private int capacity = 10;

    public void producer() throws InterruptedException {
        int value = 0;
        while (true){
            synchronized (this){
                while (linkedList.size() == capacity){
                    this.wait();
                }
                    log.info("producer add the worker: " + value);
                    linkedList.add("work: " + value);
                    value ++;
                this.notifyAll();
            }
        }
    }
    public void consumer() throws InterruptedException {
        while (true){
            synchronized (this){
                while (linkedList.size() <= 0){
                    this.wait();
                }
                log.info("consumer the worker: " + linkedList.removeFirst());
                this.notifyAll();
            }
        }
    }

    public static void main(String[] args) {

        ProduceConsumerDemo produceConsumerDemo = new ProduceConsumerDemo();

            new Thread(() ->{
                try {
                    produceConsumerDemo.producer();
                }catch (Exception e){

                }
            }).start();

            new Thread(() ->{
                try {
                    produceConsumerDemo.consumer();
                }catch (Exception e){
                }
            }).start();
    }

}
