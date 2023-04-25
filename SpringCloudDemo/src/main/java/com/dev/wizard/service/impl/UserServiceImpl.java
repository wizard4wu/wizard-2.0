package com.dev.wizard.service.impl;

import com.dev.wizard.domain.User;
import com.dev.wizard.domain.UserPo;
import com.dev.wizard.mapper.UserMapper;
import com.dev.wizard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.Collections;

import static com.dev.wizard.controller.UserController.REQUEST;
import static com.dev.wizard.controller.UserController.SRTING_TEST;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    public UserServiceImpl(){
        log.info("UserService + Constructor");
    }

    @Autowired
    private UserMapper userMapper;

    @Transactional(rollbackFor = Exception.class)
    public void addUser(User user){
        userMapper.insertUser(user.toPo());
     //   int a = 3/0;
    }

    @Override
    public void getUserById(String id, HttpServletRequest request) {
        Collections.synchronizedMap()
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String requestParameter = request.getParameter("id");
        log.info("getUserById id: {}", requestParameter);
    }

}
