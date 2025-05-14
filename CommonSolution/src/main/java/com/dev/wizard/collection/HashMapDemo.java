package com.dev.wizard.collection;

import lombok.SneakyThrows;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class HashMapDemo {

    /**
     * hashmap每次输出的顺序是不变的
     */
    public static void testHashMap() {
        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("ABCDEa123abc", "First");
        hashMap.put("ABCDFB123abc", "Fourth");
        hashMap.put("5", "Fifth");
        hashMap.put("2", "Second");
        hashMap.put("3", "Third");
        hashMap.put("11", "Sixteenth");
        hashMap.put(null, "ttt");

        hashMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        });
        hashMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        });
        hashMap.entrySet().forEach(entry -> {
            System.out.println(entry.getKey() + "---" + entry.getValue());
        });
        Map<String, String> resultMap = hashMap.entrySet().stream().takeWhile(entry -> "2".equals(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(resultMap);
    }

    public static void testMapSort() {
        Map<Integer, String> hashMap = new LinkedHashMap<>();
        hashMap.put(33, "zhangsan");
        hashMap.put(10, "lisi");
        hashMap.put(377777, "wangwu");
        hashMap.put(77, "zhaoliu");
        hashMap.put(55, "wuba");
        hashMap.entrySet().forEach(entry -> System.out.println(entry.getKey() + "---" + entry.getValue()));
    }

    //HashMap的遍历是根据链表来遍历的 即使该结构是红黑树结构
    public static Map<String, String> changeHashCode(Object hashcode, Map<String, String> map) throws NoSuchFieldException {
        Class clazz = String.class;
        Field hashField = clazz.getDeclaredField("hash");
        hashField.setAccessible(true);
        return map.entrySet().stream().collect(Collectors.toMap(entry -> {
            try {
                hashField.set(entry.getKey(), hashcode);
            } catch (IllegalAccessException ex) {
                throw new RuntimeException(ex);
            }
            return entry.getKey();}, entry -> entry.getValue()));
    }

    public static Map<String, String> initMapData() {

        Map<String, String> hashMap = new HashMap<>();
        hashMap.put("1", "First");
        hashMap.put("22", "Second");
        hashMap.put("333", "Third");
        hashMap.put("4", "Fourth");
        hashMap.put("555", "Fifth");
        hashMap.put("666", "第六");
        hashMap.put("77", "第七十七");
        hashMap.put("8", "第八");
        hashMap.put("999", "Nineth");
        hashMap.put("1000", "一千");
        hashMap.put("11", "十一");
        hashMap.put("12", "十二");
        hashMap.put("13", "十三");
        return hashMap;
    }

    public static void main(String[] args) throws NoSuchFieldException {

        testComputeIfAbsent();
    }

    public static void testComputeIfAbsent() {
        Map<String, List<String>> map = new HashMap<>();
        map.computeIfAbsent("1", key -> new ArrayList<>()).add("test");
        map.computeIfAbsent("1", key -> new ArrayList<>()).add("test3");
        System.out.println(map);
    }

}
