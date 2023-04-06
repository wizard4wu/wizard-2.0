package com.dev.wizard.service.impl;

import com.dev.wizard.domain.User;
import com.dev.wizard.mapper.UserMapper;
import com.dev.wizard.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        int a = 3/0;
    }

}
