package com.dev.wizard.research.proxy;

import com.dev.wizard.research.proxy.service.UserService;
import com.google.common.eventbus.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

@EnableAspectJAutoProxy
@ComponentScan("com.dev.wizard")
public class AppConfig {

    @Autowired
    private UserService userService;

    @Autowired
    private EventBus eventBus;

    @PostConstruct
    public void init(){
        eventBus.register(userService);
    }


}
