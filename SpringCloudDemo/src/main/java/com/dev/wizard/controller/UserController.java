package com.dev.wizard.controller;

import com.dev.wizard.domain.UserPo;
import com.dev.wizard.domain.vo.UserVo;
import com.dev.wizard.service.UserService;
import com.dev.wizard.service.impl.UserServiceImpl;
import com.dev.wizard.util.MyFactoryBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.Servlet;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    private UserServiceImpl userService;
    @Autowired
    private MyFactoryBean myFactoryBean;
    public static final InheritableThreadLocal<UserPo> SRTING_TEST = new InheritableThreadLocal<>();

    public static final InheritableThreadLocal<HttpServletRequest> REQUEST = new InheritableThreadLocal<>();
    @PostMapping("/create")
    public void createUser(@RequestBody UserVo userVo){
        userService.addUser(userVo.to());
    }

    @GetMapping("/get")
    public void getUser(@RequestParam("id") String id, HttpServletRequest request) throws InterruptedException {
        String requestParameter = request.getParameter("id");
        log.info("getUser: {}", requestParameter);
        new Thread(() -> {
            userService.getUserById(id, request);
        }).start();
        //Thread.sleep(3000l);
        log.info("getUser finish");
    }
}
