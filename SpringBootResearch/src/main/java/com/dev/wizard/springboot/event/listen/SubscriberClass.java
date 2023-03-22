package com.dev.wizard.springboot.event.listen;

import com.dev.wizard.domain.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * 1. 使用实现ApplicationListener接口的方式；
 * 2. 使用加上@EventListener注解的方式；
 */

@Component
public class SubscriberClass implements ApplicationListener<CurrentUser> {

    private static final Logger log = LoggerFactory.getLogger(SubscriberClass.class);
    @Override
    public void onApplicationEvent(CurrentUser currentUser) {
        log.info("SubscriberClass + onApplicationEvent + " + currentUser.getName());
    }


    public void handleCurrentUserThird(CurrentUser currentUser){
        log.info("SubscriberClass + handleCurrentUser + " + currentUser.getName());
    }
}
