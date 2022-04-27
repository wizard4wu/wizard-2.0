package com.dev.wizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class CustomRedisStarter {
    public static void main(String[] args) {
        SpringApplication.run(CustomRedisStarter.class, args);
    }

//    public static void main(String[] args) throws InterruptedException {
//        while (true){
//
//            Collections.EMPTY_LIST;
//            Thread.sleep(3600 * 1000);
//            System.out.println("电脑别关机");
//        }
//    }
}
