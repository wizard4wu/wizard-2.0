package com.wizard.security.custom.token;

import com.wizard.security.custom.domain.LoginUser;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class JWTAuthToken extends PreAuthenticatedAuthenticationToken {

    private String jwtToken;

    private LoginUser loginUser;


    public JWTAuthToken(Object aPrincipal, Object aCredentials) {
        super(aPrincipal, aCredentials);
    }
}
