package com.dev.wizard.concurrent;

import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

import java.util.Date;
import java.util.List;

public class ExposeLocalReference {


    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("1234");
//        list.add("12344");
//        list.add("12345");
//
//        list.remove(0);
//        list.remove(0);
//        list.remove(0);


        Date startTime = new Date(1970, 1, 1, 0, 0, 0);
        Instant endTime = startTime.toInstant().plus(2147483647, ChronoUnit.SECONDS);
        Date datee = Date.from(endTime);
        System.out.println(endTime.toEpochMilli());
        System.out.println(datee);
        Date date = new Date(2038, 1, 19, 3, 14, 7);
        System.out.println(date.toInstant().toEpochMilli());
        Instant time = Instant.now().plus(5400L, ChronoUnit.DAYS);
        long a = time.toEpochMilli();
        //Date.from();
//        ExposeLocalReference exposeLocalReference = new ExposeLocalReference();
//        exposeLocalReference.method3(1000);
    }


    private void method1(List<String> list, int number){
        list.add("test" + number);
        System.out.println("list add test" + number);
    }
    private void method2(List<String> list, int number){
        System.out.println("size + " + list.size());
        new Thread(() -> {

            String remove = list.remove(0);
            System.out.println("list remove test" + number + " size:" + list.size());
            //System.out.println("list： 0->" + list.get(0) + " 1->" + list.get(1) + " 2->" + list.get(2));}
        }).start();
    }
    private void method3(int loopTimes){
         List<String> stringList = new ArrayList<>();
        for(int i = 0; i < loopTimes; i++){
            method1(stringList, i);
            method2(stringList, i);
        }
    }
}
