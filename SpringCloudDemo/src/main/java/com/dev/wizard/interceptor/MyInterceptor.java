package com.dev.wizard.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在这里处理拦截的逻辑
        System.out.println("Intercepted request to: " + request.getRequestURI());
        return true;  // 返回 true 继续处理请求，返回 false 则终止请求
    }
}