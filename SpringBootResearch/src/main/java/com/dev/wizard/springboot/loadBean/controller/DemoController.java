package com.dev.wizard.springboot.loadBean.controller;

import com.dev.wizard.springboot.loadBean.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoController {

    @Autowired
    private OrderService orderService;

    public DemoController(){
        System.out.println("我是DemoController");
    }

    @GetMapping("/get")
    public String stringValue(){
        return orderService.retriveValue();
    }
}
