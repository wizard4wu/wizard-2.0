package com.dev.wizard.design.pattern.single;

public class InternalClass {

    private InternalClass(){
        System.out.println("InternalClass Constructor");
    }

    static class InternalClassStatic{
        private static InternalClass INSTANCE = new InternalClass();
    }

    public static InternalClass getInstance(){
        return InternalClassStatic.INSTANCE;
    }
    public static void initMethod(){
        System.out.println("initMethod");
    }

    public static void main(String[] args) {
        initMethod();
        System.out.println(getInstance());
        System.out.println(getInstance());
    }
}
