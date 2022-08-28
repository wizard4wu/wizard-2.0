package com.dev.wizard.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("/get/hello")
    public String get(){
        return "Hello World +++++";
    }
}

