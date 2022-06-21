package com.dev.wizard.design.pattern.proxy;

public class TargetClass implements ProxyInterface{

    @Override
    public void transactionMethod() {
        System.out.println("执行sql语句");
    }
}
