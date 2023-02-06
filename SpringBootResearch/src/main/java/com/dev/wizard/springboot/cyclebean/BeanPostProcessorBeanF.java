package com.dev.wizard.springboot.cyclebean;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Service
public class BeanPostProcessorBeanF implements BeanPostProcessor {


    @Autowired
    BeanFactory beanFactory;
    private static final Logger log = LoggerFactory.getLogger(BeanPostProcessorBeanF.class);

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        log.info("postProcessBeforeInstantiation + " + beanName);
        return null;
    }

    public BeanPostProcessorBeanF(){
        log.info("BeanPostProcessorBeanF + Constructor");
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
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        return bean;
    }
}
