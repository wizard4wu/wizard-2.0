package com.dev.wizard.proxy.agent;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AgentDemo {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(Config.class);

        TestService testService = applicationContext.getBean(TestService.class);
        testService.first();
    }
}
