package com.dev.wizard.juc;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
@Slf4j
public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() ->{
            log.info("hello");
            return "hh";
        });

        String a = future.get();
        log.info("result: {}", a);
    }
}
