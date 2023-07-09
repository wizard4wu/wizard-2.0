package com.dev.wizard.feign;

import com.dev.wizard.config.MyEurekaClientConfig;
import com.dev.wizard.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "user", configuration = MyEurekaClientConfig.class,fallbackFactory = OrderClientFallBackFactory.class)
public interface UserFeignClient {
    @GetMapping("/user/{id}")
    UserDTO getByUserId(@PathVariable("id") String id);
}
