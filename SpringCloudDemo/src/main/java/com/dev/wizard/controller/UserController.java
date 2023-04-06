package com.dev.wizard.controller;

import com.dev.wizard.domain.vo.UserVo;
import com.dev.wizard.service.UserService;
import com.dev.wizard.util.MyFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private MyFactoryBean myFactoryBean;

    @PostMapping("/create")
    public void createUser(@RequestBody UserVo userVo){
        userService.addUser(userVo.to());
    }
}
