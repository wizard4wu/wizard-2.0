package com.dev.wizard.controller;

import com.dev.wizard.domain.dto.OrderDTO;
import com.dev.wizard.feign.OrderFeignClient;
import com.dev.wizard.feign.UserFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/eureka")
public class EurekaController {
    @Autowired
    private OrderFeignClient orderFeignClient;
    @Autowired
    private UserFeignClient userFeignClient;

    @GetMapping("/order")
    public OrderDTO getOrder(@RequestParam("orderId") String orderId){
        OrderDTO orderDTO = orderFeignClient.getOrderById(orderId);
        return orderDTO;
    }
}
