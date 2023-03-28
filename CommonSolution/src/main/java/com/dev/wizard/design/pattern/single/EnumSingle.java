package com.dev.wizard.design.pattern.single;

/**
 * 枚举实现单例天然屏蔽了反序列化和反射方式破坏单例
 * enum通过静态的方式调用有参构造函数创建枚举对象 饥汉式
 * 有参(枚举名字， 顺序号)
 */
public enum EnumSingle {
    INSTANCE;

    //枚举默认是私有的构造函数
    EnumSingle() {
        System.out.println("EnumSingle");
    }

    public static EnumSingle getInstance(){
        return INSTANCE;
    }

    public static void testInit() {
        System.out.println("EnumSingle + testInit");
    }

    public static void main(String[] args) {
        System.out.println(EnumSingle.getInstance().hashCode());
        System.out.println(EnumSingle.getInstance().hashCode());

    }
}
