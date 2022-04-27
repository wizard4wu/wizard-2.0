package com.wizard.security.custom.token;

import com.wizard.security.custom.domain.LoginUser;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class SessionAuthToken extends PreAuthenticatedAuthenticationToken {

    private String sessionId;

    private LoginUser loginUser;

    public SessionAuthToken(String sessionId, LoginUser loginUser) {
        super(sessionId, loginUser);
        this.sessionId = sessionId;
        this.loginUser = loginUser;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return sessionId;
    }

    @Override
    public Object getPrincipal() {
        return loginUser;
    }
}
