package com.dev.wizard.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MyInterceptorConfig extends WebMvcConfigurerAdapter {

    public void addInterceptors(InterceptorRegistry registry) {
        PathMatcher pathMatcher = new AntPathMatcher();
            registry.addInterceptor(myInterceptor()).pathMatcher()
                    .addPathPatterns("/docker/get/hello");

    }
    public void configurePathMatch(PathMatchConfigurer configurer) {

        configurer.setUseTrailingSlashMatch(true);
    }
    @Bean
    public MyInterceptor myInterceptor(){
        return new MyInterceptor();
    }
}
