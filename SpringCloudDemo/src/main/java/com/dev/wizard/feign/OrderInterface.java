package com.dev.wizard.feign;

import com.dev.wizard.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(url= "localhost:80",value = "ORDER", fallbackFactory = OrderClientFallBackFactory.class)
public interface OrderInterface {
    @GetMapping("/order/byId")
    OrderDTO getOrderById(@RequestParam("id") String id, @RequestHeader("null_header") String nullableHeader, @RequestHeader(value = "order_key", required = false) String orderKey);
}

@Component
class OrderClientFallBackFactory implements FallbackFactory<OrderInterface>{

    @Override
    public OrderInterface create(Throwable cause) {
        return new OrderClientFallBack(cause);
    }

    @Slf4j
    static class OrderClientFallBack implements OrderInterface{
        private final Throwable cause;
        OrderClientFallBack(Throwable cause){
            this.cause = cause;
        }
        @Override
        public OrderDTO getOrderById(String id, String nullableHeader, String orderKey) {
            log.error("getOrderId", cause);
            return null;
        }
    }
}
