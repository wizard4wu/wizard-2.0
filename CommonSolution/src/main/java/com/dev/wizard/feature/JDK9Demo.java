package com.dev.wizard.feature;


import com.dev.wizard.domain.LoginUser;
import com.dev.wizard.domain.Person;
import com.google.common.collect.Maps;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class JDK9Demo {
    public static void createCollection() {
        //1.静态工厂方式方便创建集合对象，注意创建的集合对象都不允许任何写操作, 所有的都不可以为null
        List<String> list = List.of("test1", "test2", "test3");
        //list.set(0, "test1_update");  报UOE错
        for(String str : list){
            System.out.println(str);
        }

        //set/map不能保证输出的顺序和定义元素/键值对的顺序一致
        Set<String> set = Set.of("test1", "test2", "test3");
        Map<String, String> map = Map.of("1", "test1", "2", "test2", "3", "test3");
        Map<String, String> map2 = Map.ofEntries(Map.entry("1", "test1"), Map.entry("2", "test2"));
        System.out.println(map);
    }

    public static void newStreamMethod() {
        //1.takeWhile 从头遍历 遇到不满足就结束流 返回从头到不满足的截断结果  作用类似break
        //如果使用不可修改的Set或者Map 在使用这个方法是要注意 会存在每次输出的结果都是不一样的
        List<Integer> list = List.of(1, 2, 33, 44, 4);
        List<Integer> takeWhileResult = list.stream().takeWhile(value -> value < 33).collect(Collectors.toList());
        System.out.println(takeWhileResult);  //[1, 2]

        //2.dropWhile 从头开始删除 遇到不满足的就结束流 返回原始流剩下的结果
        List<Integer> dropWhileResult = list.stream().dropWhile(value -> value < 33).collect(Collectors.toList());
        System.out.println(dropWhileResult);  //[33, 44, 4]
    }
    public static void testMap(){
        //该Map内部有个随机盐Salt，在JVM的生命周期是不变的，每次启动会变化
        Map<String, String> map = Map.of("hello", "world", "张三","李四", "Tom", "Jerry", "罗密欧", "朱丽叶");
//      Map<String, String> resultMap = map.entrySet().stream().takeWhile(entry -> "Tom".equals(entry.getKey())).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
//      System.out.println(resultMap);
    }

    public static void testHashSet(){
        Set<String> set = new HashSet<>();
        set.add("ABCDEa123abc");
        set.add("ABCDFB123abc");
        set.add("tt");
        set.add("ee");
        set.add("yy");
        set.forEach( s -> System.out.println(s));
        set.forEach( s -> System.out.println(s));
        set.forEach( s -> System.out.println(s));
    }
    public static void testSetStaticFactory(){
        Set<String> set = Set.of("he", "zz", "tt", "ee", "yy");
        set.forEach( s -> System.out.println(s));
        set.forEach( s -> System.out.println(s));
        set.forEach( s -> System.out.println(s));
    }

    public static void newOptionalMethod() {
        //1.提供了Optional对象的流化
        Optional.ofNullable("testString").stream().toList();
        //实在是显得鸡肋，我们日常开发中Optional主要用于对象的判空，但是对于集合对象要求不返回null而是空集合，这时基本用不到Optional；
        //再者stream一般都用于集合的，如果只有一个对象没有必要做流化操作；

        LoginUser loginUser = new LoginUser();
        loginUser.setName("Test");
        List<String> list = Arrays.asList("eat", "sleep", "dadoudou");
        loginUser.setHobbies(list);
        Optional.ofNullable(loginUser)
                .map(LoginUser::getHobbies)
                .orElse(Collections.emptyList())
                .stream().filter(value -> value.equals("eat"))
                .collect(Collectors.toList());

        Optional.ofNullable(loginUser)
                .map(LoginUser::getHobbies)
                .stream()
                .flatMap(Collection::stream)
                .filter(value -> value.equals("eat"))
                .collect(Collectors.toList());

        //2.Optional 增强方法 if-else
        Person person = new Person();
        person.setId("test");

        //if-else
        if (null != person) {
            System.out.println("Hello " + person.getId());
        } else {
            System.out.println("World");
        }
        Optional.ofNullable(person)
                .ifPresentOrElse(value -> System.out.println("Hello " + value.getId()),
                        () -> System.out.println("World"));
        //only if
        if (null != person) {
            System.out.println("Hello " + person.getId());
        }
        Optional.ofNullable(person)
                .ifPresent(value -> System.out.println("Hello " + value.getId()));


        //3. Optional增强方法or
        /**
         *      Xxxx xxxx= xxxxService.getXxxxById();
         *      if( null == xxxx ){
         *        xxxx = bbbbService.getXxxxById();
         *        if( null == xxxx ){
         *        .....
         *        }
         *      }
         */

        Person nullPerson = null;
        //普通的方式：
        String result0 = null;
        if(null == nullPerson){
            Person person1 = new Person();
            result0 = person1.getId();
            if(null == person1){
                Person person2 = new Person();
                person2.setId("test2");
                result0 = person2.getId();
            }else {
                result0 = "id";
            }
        }

        String result = Optional.ofNullable(nullPerson)
                .or(() -> {
                    Person person1 = new Person();
                    person1.setId("test1");
                    return Optional.ofNullable(person1);
                })
                .or(() -> {
                    Person person2 = new Person();
                    return Optional.ofNullable(person2);
                })
                .map(Person::getId)
                .orElse("id");
        System.out.println(result);
    }

    public static void main(String[] args) {
         // createCollection();
        //  newStreamMethod();
        //newOptionalMethod();
        //testHashSet();
        //testSetStaticFactory();
        //System.out.println(tableSizeFor(33));
    }
}
