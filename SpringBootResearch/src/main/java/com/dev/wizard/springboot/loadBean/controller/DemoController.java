package com.dev.wizard.springboot.loadBean.controller;

import com.dev.wizard.springboot.loadBean.service.OrderService;

import jdk.internal.reflect.MethodAccessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private OrderService orderService;

    public DemoController(){
        System.out.println("我是DemoController");
    }

    @GetMapping("/get")
    public String stringValue(){
        return orderService.retriveValue();
    }

    @GetMapping("/hhh")
    public String getHhh(){
        return "hhh";
    }

    @GetMapping("/invoke")
    public void testInvoke() throws Exception{
        Class testClass = TestClass.class;
        TestClass testObj = new TestClass();
        Method testMethod = testClass.getMethod("testMethod", String.class);
        Method testVoidMethod = testClass.getMethod("testVoidMethod", String.class);
        printProxyMethod(testObj, testMethod);
        printProxyMethod(testObj, testVoidMethod);
    }

    static class TestClass{

        public String testMethod(String value){
            System.out.println("testMethod");
            return "testMethod" + value;
        }

        public void testVoidMethod(String value){
            System.out.println("testVoidMethod");
        }
    }

    public static void printProxyMethod(TestClass testClass, Method testMethod){
        IntStream.range(0, 18).forEach(index -> {
            try {
                testMethod.invoke(testClass, "Hello");
                Field field = testMethod.getClass().getDeclaredField("methodAccessor");
                field.setAccessible(true);
                MethodAccessor f = (MethodAccessor) field.get(testMethod);
                Field field1 = f.getClass().getDeclaredField("delegate");
                field1.setAccessible(true);
                System.out.println(field1.get(f).toString() + "---" + index);
            } catch (Exception e ) {
                e.printStackTrace();
            }
        });
    }
}
