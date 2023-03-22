package com.dev;

import com.dev.wizard.bean.BeanA;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class MyConfiguration {

    @Bean
    public BeanA sameBeanA(){
        log.info("MyConfiguration + sameBeanA");
        return new BeanA();
    }
}
