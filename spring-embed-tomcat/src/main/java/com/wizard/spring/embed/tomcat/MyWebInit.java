package com.wizard.spring.embed.tomcat;

import com.wizard.spring.embed.tomcat.config.AppConfig;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Map;

public class MyWebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        // Load Spring web application configuration
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(AppConfig.class);

        // Create and register the DispatcherServlet 之前此处应该是配在xml文件中的
        //DispatcherServlet 是SpringMVC的入口 但是得注入到tomcat中 由Spring创建
        //Tomcat 服务器第一次使用Servlet时，负责初始化
        //DispatcherServlet初始化：主要初始化了处理器映射器  处理器适配器 还有异常处理器等
        DispatcherServlet servlet = new DispatcherServlet(context);
        ServletRegistration.Dynamic registration = servletContext.addServlet("app", servlet);
        //设置大于0的值 tomcat启动就会初始化servlet
        //registration.setLoadOnStartup(0);
        registration.addMapping("/");
    }
}