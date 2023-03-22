package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.DestructionAwareBeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.config.SmartInstantiationAwareBeanPostProcessor;
import org.springframework.beans.factory.support.AbstractBeanFactory;
import org.springframework.beans.factory.support.MergedBeanDefinitionPostProcessor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

import java.util.Set;

@Slf4j
@Order
@Service
public class BeanCWithPostProcessor implements BeanPostProcessor{
    private static final Set<String> BEAN_SET = Set.of("beanA", "beanB", "beanC", "beanCWithPostProcessor", "proxyBeanA", "proxyBeanB", "beanD", "beanConfiguration");

    public Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException {
        if (BEAN_SET.contains(beanName)) {
            log.info("BeanCWithPostProcessor + postProcessBeforeInstantiation, BeanName: {}", beanName);
        }
        return null;
    }

    public BeanCWithPostProcessor() {
        log.info("BeanCWithPostProcessor Constructor");
    }

    public boolean postProcessAfterInstantiation(Object bean, String beanName) throws BeansException {
        if (BEAN_SET.contains(beanName)) {
            log.info("BeanCWithPostProcessor + postProcessAfterInstantiation, BeanName: {}, bean: {} ", beanName, bean);
        }
        return true;
    }


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (BEAN_SET.contains(beanName)) {
            log.info("BeanCWithPostProcessor + Before, BeanName: {}, bean: {}", beanName, bean);
        }
        return bean;
    }


    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (BEAN_SET.contains(beanName)) {
            log.info("BeanCWithPostProcessor + After, BeanName: {}, bean: {} ", beanName, bean);
        }
        return bean;
    }



}
