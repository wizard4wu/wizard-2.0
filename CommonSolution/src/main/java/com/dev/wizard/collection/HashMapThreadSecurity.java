package com.dev.wizard.collection;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.HashMap;
import java.util.Map;

@Data
public class HashMapThreadSecurity {
    public static void main(String[] args) throws InterruptedException {
        Map<String, String> map = new HashMap(8);
        map.put("1", "一");
        map.put("2", "二");
        map.put("3", "三");
        map.put("4", "四");

        map.put("11", "十一");
        map.put("12", "十二");

        new Thread(() -> {
            map.put("35", "三十五");
        }, "线程一").start();

        new Thread(() -> {

            map.put("12", "twelve");
        }, "线程二").start();


        Thread.sleep(2000l);

        Thread.sleep(3000l);
        System.out.println(map);
    }
}
