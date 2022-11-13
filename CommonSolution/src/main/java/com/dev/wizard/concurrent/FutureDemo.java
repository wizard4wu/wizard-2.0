package com.dev.wizard.concurrent;

import lombok.Data;
import lombok.SneakyThrows;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.time.Instant;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FutureDemo {


    public static void main(String[] args) {
        ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
        threadPoolTaskExecutor.setCorePoolSize(10);
        threadPoolTaskExecutor.setMaxPoolSize(15);
        threadPoolTaskExecutor.setQueueCapacity(20);
        threadPoolTaskExecutor.setKeepAliveSeconds(100);
        threadPoolTaskExecutor.setAllowCoreThreadTimeOut(true);
        threadPoolTaskExecutor.initialize();

        Instant start = Instant.now();
//        串行调用
//        List<String> resultList = IntStream.range(0, 4)
//                .mapToObj(index -> MockHttpClass.mockHttpCall(String.valueOf(index)))
//                .collect(Collectors.toList());
//        resultList.forEach(System.out::println);


        //并行调用
        List<Future<String>> futureList = IntStream.range(0, 6).mapToObj(index ->
                        threadPoolTaskExecutor.submit(() -> MockHttpClass.mockHttpCall(String.valueOf(index))))
                .collect(Collectors.toList());
        futureList.forEach(future -> {
            String value = null;
            try {
                value = future.get(3, TimeUnit.SECONDS);
            } catch (InterruptedException | TimeoutException | ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println(value);
        });



        Instant end = Instant.now();
        System.out.println("耗时：" + (end.toEpochMilli() - start.toEpochMilli()) / 1_000);
        ProductPo productPo = new ProductPo();
        Integer value = productPo.getPrice() + 50;
    }
    @Data
  static class ProductPo{
        private Integer price;
        private Integer number;
    }



}
