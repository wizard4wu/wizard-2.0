package com.wizard.security.custom.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReadySecurityController {

    @GetMapping("/ready/security/test")
    public String testReadySecurity(){
        return "Hello World";
    }

    @GetMapping("/ready/security/get")
    public String testGET(){
        return "Test Get";
    }

    @PostMapping("/ready/security/post")
    public String testPost(){
        return "Test Post";
    }

    @GetMapping("/ready/security/samePath/test")
    public String testSamePathGet(){
        return "Test Same Path Get";
    }
    @DeleteMapping("/ready/security/samePath/test")
    public String testSamePathDelete(){
        return "Test Same Path Delete";
    }

}
