package com.dev.wizard.juc;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;
import java.util.stream.IntStream;

public class ForkJoinPoolDemo {
    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        Long sum = forkJoinPool.invoke(new TaskWithResult(getLongArray(100), 0, 99));
        //forkJoinPool.execute();
        System.out.println(sum);
    }

    private static Long[] getLongArray(int number){

        Long[] array = new Long[number];

        int sum = 0;
        for(int index = 0; index < number; index++){
            array[index] = (long)index;
            sum += index;
        }
        System.out.println("sum:" + sum);
        return array;
    }

    private static class TaskWithoutResult extends RecursiveAction {

        @Override
        protected void compute() {

        }
    }

    private static class TaskWithResult extends RecursiveTask<Long> {

        private Long[] data;
        private int start;
        private int end;

        public TaskWithResult(Long [] data, int start, int end){
            this.data = data;
            this.start = start;
            this.end = end;
        }
        @Override
        protected Long compute() {
            if(end - start < 10){
                long total = 0;
                for(int index = start; index <= end; index++){
                     total += data[index];
                }
                return total;
            }else {
                int middle = (end + start)/2;
                TaskWithResult taskLeft = new TaskWithResult(data, start, middle);
                TaskWithResult taskRight = new TaskWithResult(data, middle + 1, end);
                taskRight.fork();
                taskLeft.fork();
                return taskRight.join() + taskLeft.join();
            }
        }
    }

}
