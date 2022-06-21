package com.dev.wizard.design.pattern.proxy;

public class ProxyClass implements ProxyInterface{

    private ProxyInterface proxyInterface;

    public ProxyClass(ProxyInterface proxyInterface){
        this.proxyInterface = proxyInterface;
    }

    @Override
    public void transactionMethod() {
        System.out.println("关闭自动提交");
        this.proxyInterface.transactionMethod();
        System.out.println("提交事务");
    }
}
