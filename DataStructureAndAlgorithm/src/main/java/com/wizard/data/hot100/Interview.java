package com.wizard.data.hot100;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Interview {
    public static void main(String[] args) throws IllegalAccessException {
        SimpleIOCContainer simpleIOCContainer = new SimpleIOCContainer();

        simpleIOCContainer.putBean(UserService.class);
        simpleIOCContainer.putBean(OrderService.class);
        simpleIOCContainer.putBean(UserService.class);

        Map<Class<?>, Object> beans = simpleIOCContainer.getAllBeans();
        for(Map.Entry<Class<?>, Object> entry : beans.entrySet()) {
            System.out.println(entry.getKey() + ":" + entry.getValue());
        }
    }

    class UserService {

    }
    class OrderService {

    }
   public static class SimpleIOCContainer {

        private static final int MAX_SIZE = 10;
        private Map<Class<?>, Object> beans = new ConcurrentHashMap<>(10);
        private AtomicInteger beanCounter = new AtomicInteger(0);
        public <T> T getBean(String beanName) throws IllegalAccessException {
            if(beanCounter.get() > MAX_SIZE) {
                throw new IllegalAccessException();
            }
            return (T) beans.get(beanName);
        }

        public <T> void putBean(Class<?> bean) throws IllegalAccessException {
            if(getBean(bean.getName()) != null) {
                return;
            }
            T object;
            try {
                object = (T) bean.getClass().getConstructor().newInstance();
                beanCounter.incrementAndGet();
            } catch (Exception e) {
                //打印错误日志
                return;
            }
            if (beanCounter.get() > MAX_SIZE) {
                throw new IllegalAccessException();
            }
            beans.put(bean.getClass(), object);
        }
        public Map<Class<?>, Object> getAllBeans(){
            return beans;
        }
    }
}
