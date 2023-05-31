package com.dev.wizard.util;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class MyFactoryBean implements FactoryBean{
    @Override
    public MyFactoryBean.MyFactoryBeanObject getObject() throws Exception {
        MyFactoryBean.MyFactoryBeanObject object = new MyFactoryBeanObject();
        object.number = 3;
        return object;
    }

    @Override
    public Class<?> getObjectType() {
        return MyFactoryBeanObject.class;
    }


    public static class MyFactoryBeanObject{
        public MyFactoryBeanObject(){
            System.out.println("ddd");
        }
        private int number;
    }
}
