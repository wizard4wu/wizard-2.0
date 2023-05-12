package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SwitchPrintDemo {

    static volatile boolean flag = false;
    public static void main(String[] args) {

        PrintObj printObj = new PrintObj();
        new Thread(() -> {
            printObj.printA();
        }, "thread1").start();

        new Thread(() -> {
            printObj.printB();
        }, "thread2").start();
    }


    public static class PrintObj{
        private volatile boolean flag = false;
        public void printA(){
            while (true){
                if(!flag){
                    System.out.print("A");
                    flag = true;
                }
            }
        }
        public void printB(){
            while (true){
                if(flag){
                    System.out.print("B");
                    flag = false;
                }
            }
        }
    }
}
