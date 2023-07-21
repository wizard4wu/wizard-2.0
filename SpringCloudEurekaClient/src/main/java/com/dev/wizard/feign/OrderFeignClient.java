package com.dev.wizard.feign;

import com.dev.wizard.config.MyEurekaClientConfig;
import com.dev.wizard.domain.dto.OrderDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "order", url = "http://127.0.0.1:81", configuration = MyEurekaClientConfig.class, fallbackFactory = OrderClientFallBackFactory.class)
public interface OrderFeignClient {
    @GetMapping("/order/byId")
    OrderDTO getOrderById(@RequestParam("orderId") String id);
}

@Component
class OrderClientFallBackFactory implements FallbackFactory<OrderFeignClient> {

    @Override
    public OrderFeignClient create(Throwable cause) {
        return new OrderClientFallBack(cause);
    }

    @Slf4j
    static class OrderClientFallBack implements OrderFeignClient{
        private final Throwable cause;
        OrderClientFallBack(Throwable cause){
            this.cause = cause;
        }
        @Override
        public OrderDTO getOrderById(String id) {
            log.error("exception getOrderId, ", cause);
            return null;
        }
    }
}

