package com.dev.wizard.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "USER", url = "http://127.0.0.1:81")
public interface UserFeignClient {

    @GetMapping("/user/{userId}")
    void getUserById(@PathVariable("userId") String userId);
}
