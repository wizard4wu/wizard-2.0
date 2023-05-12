package com.dev.wizard.controller;

import com.dev.wizard.domain.UserPo;
import com.dev.wizard.feign.OrderInterface;
import com.dev.wizard.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/springcloud")
@Slf4j
public class SpringCloudController {
    @Autowired
    private OrderInterface orderInterface;
    @GetMapping("/feign")
    public void testFeign(){
        System.out.println("test start");
        orderInterface.getOrderById("orderId", "null", "encodeOrderKey");
        log.info("test Feign result");
    }
}
