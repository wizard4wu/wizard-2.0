package com.dev.wizard.lambda;


public class LambdaDemo {


    public static void test(Task task){
        task.execute();
    }

    public static void test(Runnable runnable){
        runnable.run();
    }

    public static void main(String[] args) {
        test((Runnable) () -> {

        });
    }

}
