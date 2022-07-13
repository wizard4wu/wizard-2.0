package com.dev.wizard.springboot.loadBean.controller;

import com.dev.wizard.springboot.loadBean.service.SuperUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserController {

    @Autowired
    private SuperUserService superUserService;

    public UserController(){
        System.out.println("我是UserController");
    }
}
