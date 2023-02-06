package com.dev.wizard.object;

public class MultiExtendsDemo {

    public static abstract class A {
        public void test(){
            System.out.println("A + test");
        }
    }
    public static abstract class B extends A {
        public void test(){
            System.out.println("B + test");
        }
    }
    public static class C extends B{

    }

    public static void main(String[] args) {
        C c = new C();
        c.test();
    }
}
