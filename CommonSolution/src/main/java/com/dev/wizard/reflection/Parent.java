package com.dev.wizard.reflection;

public class Parent {

    private String name;

    public int age = 3;


    public void age(){
        play();
        System.out.println("Parent +" + age);
    }

    private void eat(){
        System.out.println("Parent + eat");
    }

    void walk(){
        System.out.println("Parent + walk");
    }

    public void play(){
        System.out.println("Parent + play" + age);
    }
}

