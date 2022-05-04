package com.wizard.security.custom.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping("/security/test")
    public String test() {
        return "hello world";
    }

}
