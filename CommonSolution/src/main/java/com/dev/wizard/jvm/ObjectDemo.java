package com.dev.wizard.jvm;

import org.openjdk.jol.info.ClassLayout;

//-XX:-UseCompressedOops 对象指针压缩可以减少对象的存储空间 默认开启
public class ObjectDemo {
    public static void main(String[] args) {
        ClassLayout layout = ClassLayout.parseInstance(new Person());
        System.out.println(layout.toPrintable());
    }

    public static class Person{
        private String name;
        private int number;
        private boolean flag;
        private char a;
    }
}
