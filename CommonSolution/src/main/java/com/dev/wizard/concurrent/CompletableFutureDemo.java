package com.dev.wizard.concurrent;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CompletableFutureDemo {


    public static void main(String[] args) throws ExecutionException, InterruptedException, TimeoutException {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(15);
        threadPoolTaskExecutor.setQueueCapacity(20);
        threadPoolTaskExecutor.setKeepAliveSeconds(100);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.initialize();

        List<CompletableFuture<String>> list = IntStream.range(0, 10)
                .mapToObj(index -> CompletableFuture.supplyAsync(() -> MockHttpClass.mockHttpCall(String.valueOf(index)), threadPoolTaskExecutor))
                .collect(Collectors.toList());

        List<String> result = list.stream().map(future -> {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                System.out.println(e);
            }
            return null;
        }).collect(Collectors.toList());
        result.forEach(System.out::println);
    }
}
