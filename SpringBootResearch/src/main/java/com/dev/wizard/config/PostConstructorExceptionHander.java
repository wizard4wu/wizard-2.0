package com.dev.wizard.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class PostConstructorExceptionHander implements SmartInitializingSingleton {

    @Override
    public void afterSingletonsInstantiated() {
        log.info("sss");
    }
}

