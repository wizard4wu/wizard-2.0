package com.dev.wizard.feign;

import com.dev.wizard.domain.dto.UserDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "USER")
public interface UserFeignClient {

    @GetMapping("/user/{userId}")
    UserDTO getUserById(@PathVariable("userId") String userId);
}
