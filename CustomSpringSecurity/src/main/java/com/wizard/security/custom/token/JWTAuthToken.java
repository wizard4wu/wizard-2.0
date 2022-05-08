package com.wizard.security.custom.token;

import com.wizard.security.custom.domain.LoginUser;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

import java.util.Optional;

public class JWTAuthToken extends PreAuthenticatedAuthenticationToken {

    private String jwtToken;

    private LoginUser loginUser;


    public JWTAuthToken(String jwtToken, LoginUser loginUser) {
        super(jwtToken, loginUser);
        this.jwtToken = jwtToken;
        this.loginUser = loginUser;
        Optional.ofNullable(loginUser).ifPresent( user ->  super.setAuthenticated(true));
    }

    @Override
    public Object getCredentials() {
        return this.jwtToken;
    }

    @Override
    public Object getPrincipal() {
        return this.loginUser;
    }

}
