package com.dev.wizard.controller;

import com.dev.wizard.domain.CurrentUser;
import com.dev.wizard.domain.Student;
import com.dev.wizard.springboot.event.listen.CommonSpringEventType;
import com.dev.wizard.springboot.event.listen.MyAsyncInterface;
import com.dev.wizard.springboot.event.listen.MyFinalClass;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springboot")
@Slf4j
public class SpringBootController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;
    @Autowired
    private MyAsyncInterface asyncWithoutInterface;
    @Autowired
    private MyFinalClass myFinalClass;

    @GetMapping("/event/test")
    public void eventTest() throws InterruptedException {
        log.info("eventTest controller");
        CurrentUser currentUser = new CurrentUser(this, "Tom", 34);
        applicationEventPublisher.publishEvent(currentUser);

        Student student = new Student(this, "AAA", 14);
        applicationEventPublisher.publishEvent(student);

//        CommonSpringEventType.CatEvent catEvent = new CommonSpringEventType.CatEvent(this, "Tiger");
//        applicationEventPublisher.publishEvent(catEvent);
//
//        CommonSpringEventType.DogEvent dogEvent = new CommonSpringEventType.DogEvent(this, "Dog");
//        applicationEventPublisher.publishEvent(dogEvent);

        asyncWithoutInterface.asyncMethod();

        //myFinalClass.finalClassMethod();


    }

}
