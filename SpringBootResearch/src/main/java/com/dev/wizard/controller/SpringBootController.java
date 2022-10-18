package com.dev.wizard.controller;

import com.dev.wizard.domain.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/springboot")
public class SpringBootController {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @GetMapping("/event/test")
    public void eventTest(){
        CurrentUser currentUser = new CurrentUser(this, "Tom", 34);
        applicationEventPublisher.publishEvent(currentUser);
    }

}
