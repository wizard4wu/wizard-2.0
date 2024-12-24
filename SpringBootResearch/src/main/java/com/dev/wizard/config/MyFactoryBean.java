package com.dev.wizard.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MyFactoryBean implements FactoryBean<AsyncConfig> {
    @Override
    public AsyncConfig getObject() {
        AsyncConfig asyncConfig = new AsyncConfig();

       try {
           asyncConfig.init();
       }catch (Exception e){
           log.error("failed");
       }
        return asyncConfig;
    }

    @Override
    public Class<?> getObjectType() {
        return AsyncConfig.class;
    }

    @Override
    public boolean isSingleton() {
        return true; // 返回true表示bean是单例的
    }
}
