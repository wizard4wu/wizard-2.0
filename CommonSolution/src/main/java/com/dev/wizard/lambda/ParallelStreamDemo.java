package com.dev.wizard.lambda;


import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
@Slf4j
public class ParallelStreamDemo {

    public static void main(String[] args) {
        List<Long> list = getArrayList(1_000_00L);
         testArrayList_output(list);
        testArrayList_sum(list);

//        List<Long> list = getLinkedList(1_000_000L);
//        testLinkedList__output(list);
//        testLinkedList_sum(list);
    }

    public static void testArrayList_output(List<Long> list){

        long startTime = System.currentTimeMillis();
        list.stream().forEach(value -> log.info("value: {}", value));
        long endTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        list.parallelStream().forEach(value -> log.info("value: {}", value));
        long endTime2 = System.currentTimeMillis();

        System.out.println("stream + output + ArrayList cost " + (endTime - startTime) + "ms");
        System.out.println("parallelStream + output + ArrayList cost " + (endTime2 - startTime2) + "ms");
    }

    public static void testArrayList_sum(List<Long> list){

        long startTime = System.currentTimeMillis();
        long result = list.stream().reduce(0L, Long::sum);
        long endTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        long result2 = list.parallelStream().reduce(0L, Long::sum);
        long endTime2 = System.currentTimeMillis();

        System.out.println("stream + sum + ArrayList cost " + (endTime - startTime) + "ms");
        System.out.println("parallelStream + sum + ArrayList cost " + (endTime2 - startTime2) + "ms");
    }

    private static List<Long> getArrayList(long max){
       return LongStream.range(1, max).boxed().collect(Collectors.toList());
    }

    private static List<Long> getLinkedList(long max){
        List<Long> list = new LinkedList<>();
        for(long value = 1; value <= max; value ++){
            list.add(value);
        }
        return list;
    }

    public static void testLinkedList__output(List<Long> list){

        long startTime = System.currentTimeMillis();
        list.stream().forEach(value -> log.info("value: {}", value));
        long endTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        list.parallelStream().forEach(value -> log.info("value: {}", value));
        long endTime2 = System.currentTimeMillis();

        System.out.println("stream + output + LinkedList cost " + (endTime - startTime) + "ms");
        System.out.println("parallelStream + output + LinkedList cost " + (endTime2 - startTime2) + "ms");
    }

    public static void testLinkedList_sum(List<Long> list){

        long startTime = System.currentTimeMillis();
        long result = list.stream().reduce(0L, Long::sum);

        long endTime = System.currentTimeMillis();

        long startTime2 = System.currentTimeMillis();
        long result2 = list.stream().reduce(0L, Long::sum);
        long endTime2 = System.currentTimeMillis();

        System.out.println("stream + sum + LinkedList cost " + (endTime - startTime) + "ms");
        System.out.println("parallelStream + sum + LinkedList cost " + (endTime2 - startTime2) + "ms");
    }
}
