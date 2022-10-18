package com.dev.wizard.feign;

import com.dev.wizard.domain.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(value = "ORDER", url = "http://127.0.0.1:80", fallback = OrderClient.class)
public interface OrderInterface {
    @GetMapping("/order/byId")
    OrderDTO getOrderById(@RequestParam("id") String id, @RequestHeader("null_header") String nullableHeader, @RequestHeader(value = "order_key", required = false) String orderKey);
}

@Component
class OrderClient implements OrderInterface{

    @Override
    public OrderDTO getOrderById(String id, String nullableHeader, String orderKey) {
        return null;
    }
}
