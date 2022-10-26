package com.dev.wizard.springboot.event.listen;

import com.dev.wizard.domain.CurrentUser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class SubscriberSecondClass implements ApplicationListener<CurrentUser> {
    private static final Logger logger = LoggerFactory.getLogger(SubscriberSecondClass.class);
    @Override
    public void onApplicationEvent(CurrentUser currentUser) {
        logger.info("SubscriberSecondClass + onApplicationEvent + " + currentUser.getName());
    }
}
