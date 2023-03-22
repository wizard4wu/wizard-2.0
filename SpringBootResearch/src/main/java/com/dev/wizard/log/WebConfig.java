package com.dev.wizard.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private TrackingLogFilter trackingLogFilter;

    public void addF(InterceptorRegistry registry){
       // registry.addInterceptor(trackingLogFilter);
    }
}
