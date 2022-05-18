package com.dev.wizard.research.proxy;

import com.google.common.eventbus.EventBus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class EventBusConfig {

    @Bean
    public EventBus eventBus(){
        return new EventBus();
    }

}