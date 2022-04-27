package com.wizard.spring;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;

public class AppMain {
    public static void main(String[] args) throws LifecycleException {

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(8083);
        tomcat.getConnector();
        //获取指定的绝对路径获取上下文
        Context context = tomcat.addWebapp("/", new File("src/main/webapp").getAbsolutePath());
        //此处可通过context设置servlet和listener.
        WebResourceRoot root = new StandardRoot(context);
        String path = new File("target/classes").getAbsolutePath();
        System.out.println(path);
        root.addPreResources(new DirResourceSet(root, "/WEB-INF/classes", path, "/"));
        context.setResources(root);
        tomcat.start();
        tomcat.getServer().await();
    }
}
