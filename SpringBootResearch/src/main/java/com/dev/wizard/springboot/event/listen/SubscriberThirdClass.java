package com.dev.wizard.springboot.event.listen;

import com.dev.wizard.domain.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class SubscriberThirdClass implements ApplicationListener<Student> {

    private static final Logger log = LoggerFactory.getLogger(SubscriberThirdClass.class);

    public SubscriberThirdClass(){
        System.out.println("SubscriberThirdClass .....");
    }


    @Override
    public void onApplicationEvent(Student student) {
        log.info("SubscriberThirdClass + onApplicationEvent + " + student.getName());
    }
}
