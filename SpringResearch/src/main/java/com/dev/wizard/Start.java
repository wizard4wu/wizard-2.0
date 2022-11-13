package com.dev.wizard;

import com.dev.wizard.research.proxy.AppConfig;
import com.dev.wizard.research.proxy.domain.User;
import com.dev.wizard.research.proxy.service.UserService;
import com.google.common.eventbus.EventBus;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

import static com.google.common.base.Preconditions.checkNotNull;


public class Start {

    public static void main(String[] args) {
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "SpringResearch\\cglib");
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = (UserService) applicationContext.getBean("userService");

        userService.testProxy();
        EventBus eventBus = (EventBus) applicationContext.getBean("eventBus");
        User user = new User();
        eventBus.post(user);

    }
}
