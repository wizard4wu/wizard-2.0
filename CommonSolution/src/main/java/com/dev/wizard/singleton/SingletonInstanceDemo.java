package com.dev.wizard.singleton;

public class SingletonInstanceDemo {

    private static final SingletonInstanceDemo INSTANCE = new SingletonInstanceDemo();

    private SingletonInstanceDemo(){
        if(null != INSTANCE){
            throw new RuntimeException("Can not create singleton instance by reflection");
        }
        System.out.println("SingletonInstanceDemo + constructor");
    }

    //1.饿汉式
    public static SingletonInstanceDemo getFirstInstance(){
        return INSTANCE;
    }

}
