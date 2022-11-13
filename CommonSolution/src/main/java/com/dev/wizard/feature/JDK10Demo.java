package com.dev.wizard.feature;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDK10Demo {

    public static void newFeatrue(){
        //1.类型推断 不建议大家使用 影响可读性
        var value = "Hello World";
        var list1 = List.of(1, 2, 3);
        var list2 = List.of("1", "2", "3");

        //2.集合提供了copyOf的方法 返回的不可以修改的集合 另外副本集合不会因为原集合的改变而改变
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        List<String> copyList = List.copyOf(list);
        list.add("ccc");
        System.out.println(copyList);  //[aaa, bbb]

        //3.Optional新增了orElseThrow()方法
        Optional.ofNullable(null).orElseThrow();
    }

    public static void main(String[] args) {
        newFeatrue();
    }
}
