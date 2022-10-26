package com.dev.wizard.springboot.event.listen;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

public class MyEventDemo {

    interface MyApplicationEvent{}

    interface MyApplicationListener<E extends MyApplicationEvent>{
        void handleEvent(E e);
    }

    //定义事件主体
    @Data
    public static class EventPayload implements MyApplicationEvent{
        private String name;
        public EventPayload(String name){
            this.name = name;
        }
    }

    //定义第一个监听器
    public static class EventFirst implements MyApplicationListener<EventPayload>{

        @Override
        public void handleEvent(EventPayload eventPayload) {
            System.out.println("EventFirst + " + eventPayload.getName());
        }
    }
    //定义第二个监听器
    public static class EventSecond implements MyApplicationListener<EventPayload>{

        @Override
        public void handleEvent(EventPayload eventPayload) {
            System.out.println("EventSecond + " + eventPayload.getName());
        }
    }

    //模拟定义一个Spring的内置事件
    @Data
    public static class SpringInternalPayload implements MyApplicationEvent{
        private String path;
        public SpringInternalPayload(String path){
            this.path = path;
        }
    }

    //模拟定义一个Spring的内置的监听器
    public static class SpringInternalEvent implements MyApplicationListener{

        @Override
        public void handleEvent(MyApplicationEvent myApplicationEvent) {

            /**
             * 在Spring的内置事件中  你会发现会有这种类型判断的
             * 在事件中，一个event的接收器只能处理对应的event类型，如果你在接收事件的地方用某种具体的event类型接收
             * 如果别的类型发送来了会报错的，所以在Spring内置事件中会使用接口类型接收 然后做类型判断，不是处理该event的主体类型
             * 这个接收器就不会处理
             */
            if( myApplicationEvent instanceof SpringInternalPayload){
                SpringInternalPayload springInternalPayload = (SpringInternalPayload)myApplicationEvent;
                System.out.println("SpringInternalEvent + " + springInternalPayload.getPath());
            }
        }
    }



    public static void main(String[] args) {

        List<MyApplicationListener> listenerList = Arrays.asList(new EventFirst(), new EventSecond(), new SpringInternalEvent());
        EventPayload eventPayload = new EventPayload("Hello");

        for(MyApplicationListener listener : listenerList){
            listener.handleEvent(eventPayload);
        }
    }
}
