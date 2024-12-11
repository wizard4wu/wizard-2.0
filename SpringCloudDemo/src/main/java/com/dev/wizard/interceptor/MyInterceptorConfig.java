package com.dev.wizard.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
            registry.addInterceptor(myInterceptor())
                    .addPathPatterns("/order/byId");

    }

    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
