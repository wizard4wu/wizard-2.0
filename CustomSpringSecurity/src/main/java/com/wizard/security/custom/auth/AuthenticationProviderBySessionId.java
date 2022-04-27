package com.wizard.security.custom.auth;

import com.wizard.security.custom.domain.LoginUser;
import com.wizard.security.custom.token.SessionAuthToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationProviderBySessionId implements AuthenticationProvider {
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        System.out.println("Hello World");
        System.out.println(authentication.getName());
        String sessionId = (String)authentication.getCredentials();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        return new SessionAuthToken(sessionId, loginUser);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        //填写对应的token验证
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
