package com.dev.wizard.controller;

import com.dev.wizard.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
@Slf4j
public class OrderController {

    @GetMapping("/byId")
    public OrderDTO getById(@RequestParam("orderId") String orderId) throws InterruptedException {
        log.info("orderId: {}", orderId);
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setId(orderId);
        Thread.sleep(3000l);
        return orderDTO;
    }
}
