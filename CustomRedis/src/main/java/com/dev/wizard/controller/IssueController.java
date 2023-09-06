package com.dev.wizard.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/issue")
@Slf4j
public class IssueController {
    private boolean flag;
    List<String> list = new ArrayList<>();

    @GetMapping("/dead/cycle")
    public void generateCycle(){
        int i = 0;
        flag = true;
        while (flag){
            i++;
        }
    }
    @GetMapping("/end/cycle")
    public void endCycle(){
        flag = false;
    }

    @GetMapping("/memory/error")
    public void outOfMemory(){
        int i = 0;
        while(true){
            i += 1;
            list.add(i + "hello");
            list.add("world" + i);
        }
    }

    @GetMapping("/memory/error2")
    public void outOfMemory2(){
        while(true){
           String[] stringArray = new String[10 * 1024 * 1024];
        }
    }

    @GetMapping("/stack/error")
    public void generateStackOverFlow(){
        stackOverFlow(1);
    }

    @GetMapping("/dead/lock")
    public void deadLock() throws InterruptedException {
        new Thread(() ->{
            synchronized (Object.class){
                log.info(Thread.currentThread().getName() + " Object");
                try {
                    Thread.sleep(3000l);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                synchronized (this){
                    log.info(Thread.currentThread().getName() + " this");
                }
            }
        }).start();

        synchronized (this){
            log.info(Thread.currentThread().getName() + "this");
            Thread.sleep(3000l);
            synchronized (Object.class){
                log.info(Thread.currentThread().getName() + "Object");
            }
        }
    }


    private void stackOverFlow(int i){
        if(i == 0) return;
        int j = 22;
        list.add(j + "");
        int m = j + 222;
        test(m);
    }
    private void test(int m){
        stackOverFlow(m);
    }
}
