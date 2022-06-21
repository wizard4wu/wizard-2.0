package com.dev.wizard.design.pattern.proxy;


//结构型模式 之 代理模式

//代理模式有两个概念： 代理类和目标类，两个类都要实现一个接口。  代理类是为了给目标类做一个增强的作用
public class ProxyClient {

    public static void main(String[] args) {

       ProxyInterface proxyInterface = new ProxyClass(new TargetClass());
       proxyInterface.transactionMethod();
    }
}
