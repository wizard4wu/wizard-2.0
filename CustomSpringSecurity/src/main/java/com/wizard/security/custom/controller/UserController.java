package com.wizard.security.custom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/test")
    public String getUser() {


        System.out.println("obj");

        return "hello world";
    }

}
