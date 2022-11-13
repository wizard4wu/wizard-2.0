package com.dev.wizard.feature;

import com.dev.wizard.domain.LoginUser;
import com.dev.wizard.domain.Person;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 主要演示JDK17的一些新功能
 */
public class JDK17Demo {

    public static void streamToCollection(){
        //Stream的toList方法
        //1.前两者生成的都是不可修改的集合，最后生成的是普通的list，可写。
        //2.性能比较：toList(优) --> Collectors.toList() --> Collectors.toUnmodifiableList()
        List<String> list = List.of("hhh", "www", "ttt");
        List<String> result1 = list.stream().toList();
        List<String> result2 = list.stream().collect(Collectors.toUnmodifiableList());
        List<String> result3 = list.stream().collect(Collectors.toList());

    }

    public static void main(String[] args) {

        streamToCollection();
    }


    /**
     * 可以指定抛出异常的类型
     */
    public static void optionalMethod_orElseThrow() {
        Person person = null;
        Optional.ofNullable(person).orElseThrow(() -> new NullPointerException());
    }




    /**
     * Switch增强
     */

    public static void method_switch(){
        String value = "def";

        //Before
        switch (value){
            case "abc":
                System.out.println("Hello"); break;
            case "def":
                System.out.println("World"); break;
            default:
                System.out.println("Java"); break;
        }

        //After
        switch (value){
            case "abc" -> System.out.println("Hello");
            case "def" -> System.out.println("World");
            default -> System.out.println("Java");
        }



Object obj = "value";
if(obj instanceof String){
    String newValue = obj + "TTT";
    System.out.println(newValue);
}else if(obj instanceof Integer){
    Integer number = (Integer) obj + 3;
    System.out.println(number);
}else {
    System.out.println(obj);
}

        obj = 5;
switch (obj){
    case String str -> {
        String newStr = str + "TTT";
        System.out.println(newStr);
    }
    case Integer number -> {
        Integer newNumber = number + 3;
        System.out.println(newNumber);
    }
    default -> System.out.println(obj);
}
    }

    /**
     * Switch对Null值的处理
     */
    public static void method_switch_null(){

String value = null;

switch (value){
    case null -> {
        return;
    }
    case "abc" -> System.out.println("Hello");
    case "def" -> System.out.println("World");
    default -> System.out.println("Java");
}
        System.out.println("HHHH");
    }


    public static void method_switch_with_condition(){
        Object obj = 5;
switch (obj){
    case String str -> {
        String newStr = str + "TTT";
        System.out.println(newStr);
    }
    case Integer number && number >= 5 -> {
        Integer newNumber = number + 3;
        System.out.println(newNumber);
    }
    default -> System.out.println(obj);
}
    }



    public static void recordClass(){
       // Record record = new Record();


    }





}
