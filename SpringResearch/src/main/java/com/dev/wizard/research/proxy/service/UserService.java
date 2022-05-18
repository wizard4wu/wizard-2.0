package com.dev.wizard.research.proxy.service;

import com.dev.wizard.research.proxy.domain.User;
import com.google.common.eventbus.Subscribe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Component
public class UserService {

    @Autowired
    private OrderService orderService;

    public void testProxy(){
        System.out.println("userService");
    }

    @Subscribe
    protected void testProxyPublic(User user){
        orderService.order();
        System.out.println("public orderService.toString()");
    }

    @Subscribe
    private void testProxyPrivate(User user){
        privateMethod();
       orderService.order();
       System.out.println("private orderService.toString()");
    }

    @Subscribe
    public void testCallPrivate(User user){
        this.privateMethod();
    }

    private void privateMethod(){
        orderService.order();
        System.out.println("private method");
    }
}
