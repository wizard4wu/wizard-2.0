package com.dev.wizard.proxy.cglib;

public class CglibTarget {

    public void saveMethod(){
        System.out.println("CglibTarget -- 无参 saveMethod");
    }

    public String saveMethod(int value){
        System.out.println("CglibTarget -- int参 saveMethod" + value);
        return "int参";
    }
}
