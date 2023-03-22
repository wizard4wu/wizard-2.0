package com.dev.wizard.controller;

import com.dev.wizard.bean.LazyBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/my")
public class MyController {
    @Autowired
    @Lazy
    private LazyBeanA lazyBeanA;

    @RequestMapping("/lazyBeanA")
    public void testLazyBeanA(){
        lazyBeanA.testMethod();
    }
}
