package com.dev.wizard.controller;

import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletRequest;

@RestController
public class SpringCloudController {
    @GetMapping("order/byId")
    public void byId(@RequestParam("id") String id, @RequestHeader("null_header") String nullHeader, @RequestHeader("order_key") String orderKey, ServletRequest request){
        String result = (String)request.getAttribute("order_key");
        System.out.println(result);
        System.out.println("order_key:" + orderKey);
        System.out.println("null_header:" + nullHeader);
    }
}
