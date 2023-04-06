package com.dev.wizard.service;

import com.dev.wizard.domain.User;
import com.dev.wizard.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

public interface UserService {

    void addUser(User user);
}
