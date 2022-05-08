package com.wizard.security.custom.filter;

import com.wizard.security.custom.domain.LoginUser;
import com.wizard.security.custom.token.JWTAuthToken;
import com.wizard.security.custom.util.JWTUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.stereotype.Component;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Slf4j
public class CustomTokenFilter extends AbstractAuthenticationProcessingFilter {


    public CustomTokenFilter(String defaultFilterProcessesUrl) {
        super(defaultFilterProcessesUrl);
    }

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException, IOException, ServletException {
        //String token = request.getHeader("header_token");

        String token = request.getParameter("jwt_token");

        System.out.println("=============" + request.getRequestURL());

        JWTAuthToken auth = new JWTAuthToken(token, null);
        Authentication result = getAuthenticationManager().authenticate(auth);
        //SecurityContextHolder.getContext().setAuthentication(result);
        return result;
    }

    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain
            chain, Authentication authResult) throws IOException, ServletException {
        if (authResult.getPrincipal() != null) {
            SecurityContext context = SecurityContextHolder.createEmptyContext();
            context.setAuthentication(authResult);
            SecurityContextHolder.setContext(context);
        }
        chain.doFilter(request, response);
    }
}
