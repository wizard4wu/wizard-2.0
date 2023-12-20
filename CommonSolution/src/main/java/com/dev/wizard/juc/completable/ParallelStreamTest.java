package com.dev.wizard.juc.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
public class ParallelStreamTest {
    public static void main(String[] args) {

        List<String> list = List.of("Hello", "World");
        list.parallelStream().forEach(l ->{
            try {
                log.info("before");
                Thread.sleep(2000);
                log.info("after");
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        log. info("main");
    }
}
