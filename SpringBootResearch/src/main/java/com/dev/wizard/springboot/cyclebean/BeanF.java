package com.dev.wizard.springboot.cyclebean;

import com.dev.wizard.springboot.event.listen.SubscriberClass;
import com.google.common.collect.Sets;
import lombok.SneakyThrows;
import org.apache.catalina.core.ApplicationContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.core.ReflectUtils;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.Set;

@Service
public class BeanF implements BeanPostProcessor {


    @Autowired
    BeanFactory beanFactory;
    private static final Logger log = LoggerFactory.getLogger(BeanF.class);

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("postProcessBeforeInstantiation + " + beanName);
        return null;
    }

    public BeanF(){
        log.info("beanF + Constructor");
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        log.info("postProcessAfterInstantiation + " + beanName);
        //该属性用于控制引用了该bean的对象在注入依赖时  会导致添加在该bean后面的依赖属性不能注入  //还未实验验证
        return true;
    }

    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName)
            throws BeansException {
        log.info("postProcessProperties + " + beanName);
        return null;
    }

    @PostConstruct
    public void init(){
        log.info("beanF + init");
    }

   public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        log.info("postProcessBeforeInitialization + " + beanName);
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //log.info("postProcessAfterInitialization + " + beanName);
        Arrays.stream(bean.getClass().getDeclaredMethods())
                .filter(method -> method.isAnnotationPresent(TestAnno.class))
                .forEach(method -> {
                    Object obj = beanFactory.getBean("beanC");
                    try {
                        method.invoke(obj, null);
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    } catch (InvocationTargetException e) {
                        throw new RuntimeException(e);
                    }
                });
        return bean;
    }
}
