package com.dev.wizard.concurrent;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

//设计一个简单的IOC容器，容器中bean是单例，bean数量不超过10，并验证；
public class SingleBeanContainer {

    private static final int MAX_COUNT = 10;
    private static final Map<String, Object> beanMap = new ConcurrentHashMap<>(10);
    private static final AtomicInteger counter = new AtomicInteger(0);

    public static <T> void registerBean(Class<T> clazz){
        if(beanMap.containsKey(clazz.getName())) {
            return;
        }
        beanMap.computeIfAbsent(clazz.getSimpleName(), key ->{
            if(counter.incrementAndGet() > MAX_COUNT) {
                counter.decrementAndGet();
                throw new RuntimeException("Too many registerBean");
            }
            try {
                Constructor<T> constructor = clazz.getConstructor();
                return constructor.newInstance();
            } catch (Exception e) {
                throw new RuntimeException("create bean failed", e);
            }
        });
    }

    public static <T> T getBean(String beanName) {
        return (T) beanMap.get(beanName);
    }

    public static void main(String[] args) {
        SingleBeanContainer singleBeanContainer = new SingleBeanContainer();
        UserService userService = new UserService();
        singleBeanContainer.registerBean(UserService.class);
        UserService t = singleBeanContainer.getBean("UserService");
        System.out.println();
    }

    public static class UserService{

    }
}
