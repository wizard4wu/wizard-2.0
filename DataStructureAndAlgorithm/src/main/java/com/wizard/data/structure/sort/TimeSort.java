package com.wizard.data.structure.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TimeSort {


    public static void main(String[] args) {
        List<Time> timeList = new ArrayList<>();
        timeList.add(new Time(10, 10, 43));
        timeList.add(new Time(8, 11, 43));
        timeList.add(new Time(9, 12, 33));
        timeList.add(new Time(9, 11, 45));
        timeList.add(new Time(9, 11, 43));
        timeList.add(new Time(9, 12, 43));

        Collections.sort(timeList, (o1, o2) -> {
            if(o1.hour - o2.hour > 0){
                return 1;
            }else if(o1.hour - o2.hour < 0){
                return -1;
            }else {
                if(o1.minute - o2.minute > 0){
                    return 1;
                }else if(o1.minute - o2.minute < 0){
                    return -1;
                }else {
                    if(o1.second - o2.second > 0){
                        return 1;
                    }else if(o1.second - o2.second < 0){
                        return -1;
                    }else {
                        return 0;
                    }
                }
            }
        });

        Collections.sort(timeList);
    }

    /**
     * Comparator和Comparable的比较：
     * Comparable：able结尾表示某种能力，因此某个对象实现了这个接口有了排序的能力；
     * Comparator：or表示自身就是一个比较器
     */



    public static class Time implements Comparable<Time>{
        private int hour;
        private int minute;
        private int second;
       public Time(int hour, int minute, int second){
           this.hour = hour;
           this.minute = minute;
           this.second = second;
       }

        @Override
        public int compareTo(Time o) {
           if(this.hour - o.hour > 0){
               return 1;
           }else if(this.hour - o.hour < 0){
               return -1;
           }else {
               if(this.minute - o.minute > 0){
                   return 1;
               }else if(this.minute - o.minute < 0){
                   return -1;
               }else {
                   if(this.second - o.second > 0){
                       return 1;
                   }else if(this.second - o.second < 0){
                       return -1;
                   }else {
                       return 0;
                   }
               }
           }
        }
    }
}
