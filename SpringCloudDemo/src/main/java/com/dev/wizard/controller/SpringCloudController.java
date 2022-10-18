package com.dev.wizard.controller;

import com.dev.wizard.feign.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springcloud")
public class SpringCloudController {
    @Autowired
    private OrderInterface orderInterface;
    @GetMapping("/feign")
    public void testFeign(){
        System.out.println("test");
        orderInterface.getOrderById("orderId", null, "encodeOrderKey");
    }
}
