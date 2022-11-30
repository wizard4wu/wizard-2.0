package com.dev.wizard.controller;

import com.dev.wizard.bean.ProxyBeanA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BeanController {

    @Autowired
    private ProxyBeanA proxyBeanA;

    @RequestMapping("/test")
    public void test(){
        proxyBeanA.firstTargetMethod();
    }
}
