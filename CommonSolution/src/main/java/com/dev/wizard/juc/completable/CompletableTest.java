package com.dev.wizard.juc.completable;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class CompletableTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executors = Executors.newFixedThreadPool(3);

            CompletableFuture<String> result = CompletableFuture.supplyAsync(() -> {
                try {
                    log.info("before");
                    Thread.sleep(3000);
                    log.info("after");
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return "hello";
            }).thenApply(s -> {
                log.info("wwwwww" + s);
                return s + "world";
            }).thenApply(s -> {
                log.info("tttt" + s);
                return s + ";";
            });

        result.get();
        log.info("main print");
        Thread.sleep(4000);
    }
}
