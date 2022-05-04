package com.wizard.security.service;

import com.wizard.security.custom.domain.LoginUser;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        LoginUser userdetails = new LoginUser();

        userdetails.setName(username);
        userdetails.setId("ABC");
        return userdetails;
    }
}
