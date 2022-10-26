package com.dev.wizard.controller;

import com.dev.wizard.domain.CurrentUser;
import com.dev.wizard.domain.Student;
import com.dev.wizard.springboot.event.listen.CommonSpringEventType;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springboot")
public class SpringBootController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/event/test")
    public void eventTest() throws InterruptedException {
        CurrentUser currentUser = new CurrentUser(this, "Tom", 34);
        applicationEventPublisher.publishEvent(currentUser);

        Student student = new Student(this, "AAA", 14);
        applicationEventPublisher.publishEvent(student);

//        CommonSpringEventType.CatEvent catEvent = new CommonSpringEventType.CatEvent(this, "Tiger");
//        applicationEventPublisher.publishEvent(catEvent);
//
//        CommonSpringEventType.DogEvent dogEvent = new CommonSpringEventType.DogEvent(this, "Dog");
//        applicationEventPublisher.publishEvent(dogEvent);

        //add the useless code
        Thread.sleep(3000);
        System.out.println("event publish finish");
    }

}
