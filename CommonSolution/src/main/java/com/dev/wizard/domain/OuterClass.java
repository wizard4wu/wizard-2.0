package com.dev.wizard.domain;

import java.util.ArrayList;
import java.util.List;

public class OuterClass {

    private int outerInt;

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        //list.add("eee");
        String[] strings = new String[]{"eeee"};
        List.of(strings, "ddd");

        OuterClass outerClass = new OuterClass();

        list.toArray();

        InnerClass innerClass = outerClass.new InnerClass();


    }

    public class InnerClass{
        private int innerInt;

        public InnerClass(){
            outerInt = 33;
        }
    }
    public static class StaticClass{
        private int staticClassInt;
        public StaticClass(){

        }

    }
}
class Clazz{

    private int clazzInt;

}