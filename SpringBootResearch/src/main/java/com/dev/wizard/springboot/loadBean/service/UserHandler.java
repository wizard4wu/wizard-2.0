package com.dev.wizard.springboot.loadBean.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Service;

@Service
public class UserHandler implements BeanPostProcessor, Ordered {

  public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
      if("orderService".equals(beanName)){
          System.out.println("UserHandler ------ postProcessBeforeInitialization<前置>" + beanName);
      }
        return bean;
    }

  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
      if("orderService".equals(beanName)){
          System.out.println("UserHandler=====" + beanName);
      }
      return bean;
    }

    @Override
    public int getOrder() {
        return 2;
    }
}
