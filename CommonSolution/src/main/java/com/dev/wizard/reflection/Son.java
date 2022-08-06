package com.dev.wizard.reflection;

public class Son extends Parent{

    private String name;

    private int gender = 2;

    public int age = 1;

    private void study(){
        System.out.println("Son + study");
    }

    public void swim(){
        System.out.println("Son + swim");
    }

    public void age(){
        play();
        System.out.println("Son" + age);
    }

    public void play(){
        System.out.println("Son + play" + age);
    }
}
