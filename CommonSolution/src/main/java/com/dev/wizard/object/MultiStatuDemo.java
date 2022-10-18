package com.dev.wizard.object;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MultiStatuDemo {
    public static void main(String[] args) {

        Person person = new Student();
        Method[] methods = person.getClass().getDeclaredMethods();

        Arrays.stream(methods).forEach(System.out::println);
    }


    static class Person {
        private String name;

        public void doAction(){
            System.out.println("doAction person");
        }

        public void doTest(){
            System.out.println("doTest person");
        }
    }
    static class Student extends Person{
        private int age;

        public void doAction(){
            System.out.println("doAction student");
        }
    }
}
