package com.wizard.security.custom.token;

import com.wizard.security.custom.domain.LoginUser;
import org.springframework.security.web.authentication.preauth.PreAuthenticatedAuthenticationToken;

public class SessionAuthToken extends PreAuthenticatedAuthenticationToken {

    private String headerToken;

    private LoginUser loginUser;

    public SessionAuthToken(String sessionId, LoginUser loginUser) {
        super(sessionId, loginUser);
        this.headerToken = sessionId;
        this.loginUser = loginUser;
        super.setAuthenticated(true);
    }

    @Override
    public Object getCredentials() {
        return headerToken;
    }

    @Override
    public Object getPrincipal() {
        return loginUser;
    }
}
