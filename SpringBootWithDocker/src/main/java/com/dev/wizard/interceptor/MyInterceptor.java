package com.dev.wizard.interceptor;

import org.springframework.security.web.servlet.util.matcher.MvcRequestMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class MyInterceptor implements HandlerInterceptor {

    private MvcRequestMatcher mvcRequestMatcher;

    public MyInterceptor(RequestMappingHandlerMapping handlerMapping) {
        // 构造时传入 RequestMappingHandlerMapping，定义匹配规则
        this.mvcRequestMatcher = new MvcRequestMatcher(handlerMapping, "/test/**");
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 在这里处理拦截的逻辑
        String requestURI = (String)request.getAttribute(UrlPathHelper.PATH_ATTRIBUTE);
        System.out.println("he" + requestURI);
        System.out.println("Intercepted request to: " + request.getRequestURI());
        return true;  // 返回 true 继续处理请求，返回 false 则终止请求
    }


    public void configurePathMatch(PathMatchConfigurer configurer) {
        // 设置 UrlPathHelper 确保路径正确处理
        UrlPathHelper urlPathHelper = new UrlPathHelper();
        configurer.setUrlPathHelper(urlPathHelper);
    }
}