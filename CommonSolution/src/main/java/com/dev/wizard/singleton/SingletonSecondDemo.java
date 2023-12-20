package com.dev.wizard.singleton;

public class SingletonSecondDemo {
    static {
        System.out.println("SingletonSecondDemo 静态代码块");
    }
    private SingletonSecondDemo(){
        if(null != INSTANCE){
            throw new RuntimeException("Can not create singleton instance by reflection");
        }
        System.out.println("SingletonSecondDemo + constructor");
    }
    //在该种懒汉式的情况下必须要使用volatile关键字修饰
    //该关键字可以防止指令重排序
    /**
     * 创建单例对象的步骤：
     * 1. new指令创建一个新的对象；
     * 2. invokespecial指令调用构造方法（成员变量赋值）
     * 3. putstatic指令将创建好的对象进行赋值
     * CPU的指令重排会有可能优化2 3步骤，导致对象地址提前被赋值，
     * 但是实际对象还没有完成创建，可以理解成是一个半成品的对象。
     *
     * 那对于双检查锁模式的话，线程一执行时会把3步先执行，这是对象有对应的引用了，
     * 但是实际上该对象是不完整的，线程二判断是不为空的，这时就会拿着对象直接去使用了。
     * 使用volatile关键字修饰就是杜绝了这种情况发生，按部就班的执行，一定是对象创建完成后
     * 才会对对象赋值
     */
    private static volatile SingletonSecondDemo INSTANCE = null;

    //1.懒汉式  会有线程安全问题
    public static SingletonSecondDemo getInstance(){
        if(null == INSTANCE){
            INSTANCE = new SingletonSecondDemo();
        }
        return INSTANCE;
    }

    //2.懒汉式 - 双检查锁模式
    public static SingletonSecondDemo getInstance_2(){
        if(null == INSTANCE){
            synchronized (SingletonSecondDemo.class){
                //如果没有内置检查 还是会存在创建新的对象的
                if(null == INSTANCE){
                    INSTANCE = new SingletonSecondDemo();
                }
            }
        }
        return INSTANCE;
    }

    public static SingletonSecondDemo getInstance_3(){
        return InnerClass.INNER_INSTANCE;
    }

    public static void main(String[] args) {
        getInstance_3();
    }

    //3.懒汉式 - 内部类方式 一定要保证只有本类访问该内部类 private修饰静态类
    private static class InnerClass{
        static SingletonSecondDemo INNER_INSTANCE = new SingletonSecondDemo();
        static {
            System.out.println("InnerClass 静态代码块");
        }
    }

}
