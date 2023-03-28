package com.dev.wizard.design.pattern.single;

//饿汉式/饥汉式：上来就创建一个对象

/**
 * 静态代码的执行处于类生命周期中的初始化阶段由虚拟机保证其原子且安全执行
 */
public class Hungery {

    private static final Hungery INSTANCE = new Hungery();

    private Hungery(){
        System.out.println("private Hungery Constructor ");
        //防止使用反射破坏单例模式
        if(null != INSTANCE){
            throw new RuntimeException();
        }
    }
    public static Hungery getInstance() {
        return INSTANCE;
    }
    public static void testInit(){
        System.out.println("testInit");
    }
    //防止序列化反序列化后生成新的对象 破坏单例模式
    private Object readResolve(){
        return INSTANCE;
    }

    public static void main(String[] args) {
        Hungery.testInit();
        System.out.println(Hungery.getInstance());
        System.out.println(Hungery.getInstance());
    }
}
