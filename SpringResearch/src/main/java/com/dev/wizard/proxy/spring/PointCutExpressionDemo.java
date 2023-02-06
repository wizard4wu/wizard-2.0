package com.dev.wizard.proxy.spring;

import com.dev.wizard.proxy.spring.expression.ExpressionDemo;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;

import javax.annotation.PostConstruct;
import java.lang.reflect.Method;

/**
 * *：匹配任何数量字符
 * ..：匹配任何数量字符的重复，如任何数量子包，任何数量方法参数
 * +：匹配指定类型及其子类型，仅作为后缀防过载类型模式后面。
 */

public class PointCutExpressionDemo {
    public static void main(String[] args) {

        AspectJExpressionPointcut methodNamePointCut = new AspectJExpressionPointcut();
        //execution:用于匹配方法作为切点
        methodNamePointCut.setExpression("execution (* com.dev.wizard.proxy.spring.expression.*.*(..))");

        Method[] methods = ExpressionDemo.class.getDeclaredMethods();
        for(Method method : methods){
           boolean flag = methodNamePointCut.matches(method, ExpressionDemo.class);
            if(flag){
                System.out.println(method);
            }
        }
    }
}
