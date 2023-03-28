package com.dev.wizard.bean;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.objenesis.Objenesis;
import org.springframework.objenesis.ObjenesisStd;
import org.springframework.objenesis.instantiator.ObjectInstantiator;
import org.springframework.stereotype.Service;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

@Service
@Slf4j
@Lazy
public class LazyBeanA {

    @Autowired
    @Lazy
    private LazyBeanB lazyBeanB;

    public LazyBeanA(){
        log.info("LazyBeanA + ConstructorWithoutParameter");
    }

    public void testMethod(){
        log.info("LazyBeanA + testMethod");
    }

    public void firstTargetMethod(){
        log.info("LazyBeanA + firstTargetMethod");
    }

    public static void main(String[] args) throws Exception{

        //Lazy注解底层使用了该方式
        //由于在该每个Bean注入代理Bean时，该代理Bean如果基于继承关系的话那么理论上会
        //调用父类的构造方法 实际上用了Objenesis没有触发构造方法的调用
        Objenesis objenesis = new ObjenesisStd();
        ObjectInstantiator<LazyBeanA> objectInstantiator = objenesis.getInstantiatorOf(LazyBeanA.class);
        LazyBeanA lazyBeanA = objectInstantiator.newInstance();
//        System.out.println(lazyBeanA);
//        Constructor<LazyBeanA> constructor = LazyBeanA.class.getConstructor();
//        LazyBeanA lazyBeanA = constructor.newInstance();
    }
}
