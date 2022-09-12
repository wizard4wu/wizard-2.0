package com.dev.wizard.springboot.arthas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
@RestController
@RequestMapping("/arthas")
public class ArthasController {

    @GetMapping("/test/param")
    public String getResult(@RequestParam("method") String method, @RequestParam("type") String type){

        String value = type;
        List<String> list = new ArrayList<>();
        list.add(type);
        list.add("test1");
        list.add("test2");
        staticMethod(value, list);
        if("methodChangeParam".equalsIgnoreCase(method)){
            this.methodChangeParam(value, list);
        }else if("methodWithException".equalsIgnoreCase(method)){
            this.methodWithException(0);
        }else if("methodWithEmbedParam".equalsIgnoreCase(method)){
            this.methodWithEmbedParam("h");
        }
        return "hello";
    }
    private String methodChangeParam(String value, List<String> list){
        list.add("test0");
        return value + "DDDDD";
    }
    private String methodWithException(int number){
        System.out.println("hello");
        int num = 3 + 5;
        int value = number / 0;
        return "" + value;
    }
    private List<Person> methodWithEmbedParam(String name){
        Student student1 = new Student("一年级一班", Arrays.asList("hhh", "zzz"));
        Person person = new Person("小明", student1);

        return Arrays.asList(person);
    }

    static class Student{
        private String className;
        private List<String> address;

        Student(String className, List<String> address){
            this.className = className;
            this.address = address;
        }

    }
    static class Person {
        Person(String name, Student stu){
            this.name = name;
            this.stu = stu;
        }
        private String name;
        private Student stu;
    }
    static String staticMethod(String value, List<String> list){
        list.add("staticMethod");
        return "staticMethod";
    }
}
