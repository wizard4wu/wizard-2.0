package com.dev.wizard.springboot.loadBean.handle;

import com.dev.wizard.springboot.loadBean.custom.CustomAnno;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.util.Arrays;
import java.util.Optional;

@Configuration
public class AnnoHandle implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName){
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class beanClass = bean.getClass();

        if("orderService".equals(beanName)){
            System.out.println("AnnoHandle-------" + beanName);
        }

        ReflectionUtils.doWithFields(beanClass, field -> {
            CustomAnno customAnno = field.getAnnotation(CustomAnno.class);
            Optional.ofNullable(customAnno).ifPresent( value -> {
                field.setAccessible(true);
                try {
                    field.set(bean, value.value());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            });
        });
        return bean;
    }
}
