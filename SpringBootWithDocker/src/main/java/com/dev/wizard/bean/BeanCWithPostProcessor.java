package com.dev.wizard.bean;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
@Slf4j
public class BeanCWithPostProcessor implements BeanPostProcessor {
    private static final Set<String> BEAN_SET = Set.of("beanA", "beanB", "beanCWithPostProcessor");

    public BeanCWithPostProcessor(){
        log.info("BeanCWithPostProcessor Constructor");
    }

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if(BEAN_SET.contains(beanName)){
            log.info("BeanCWithPostProcessor + Before + " + beanName);
        }
        return bean;
    }



    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(BEAN_SET.contains(beanName)){
            log.info("BeanCWithPostProcessor + After + " + beanName);
        }
        return bean;
    }
}
