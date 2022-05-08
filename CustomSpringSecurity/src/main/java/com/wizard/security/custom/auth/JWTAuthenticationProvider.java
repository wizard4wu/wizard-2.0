package com.wizard.security.custom.auth;

import com.wizard.security.custom.domain.LoginUser;
import com.wizard.security.custom.token.JWTAuthToken;
import com.wizard.security.custom.util.JWTUtil;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class JWTAuthenticationProvider implements AuthenticationProvider {
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {

        String token = (String) authentication.getCredentials();

        LoginUser user = JWTUtil.parseToken(token);
        return new JWTAuthToken(token, user);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(JWTAuthToken.class);
    }
}
