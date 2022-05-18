package com.dev.wizard.research.autoconfig.app;

import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

import java.io.File;


public class AutoConfigApplication {

    public static void run(){
        //new一个tomcat
        Tomcat tomcat=new Tomcat();
        //设置端口号
        tomcat.setPort(7077);
        tomcat.getConnector();
        //获取项目编译后的classes 路径
        String path = AutoConfigApplication.class.getResource("/").getPath();

        System.out.println("Path:" + path);
        //获取webapp 文件
        String filePath = new File("src/main/webapp/").getAbsolutePath();

        System.out.println("filePath:" + filePath);
        //然后将webapp下的项目添加至tomcat的context容器（context对应一个运行的项目）
        Context context =tomcat.addWebapp("/",filePath); //参数1：一般是项目名 对应请求url中的项目名
        try {

            //webResourceRoot 用于加载 项目的class文件
            WebResourceRoot webResource = new StandardRoot(context);
            webResource.addPreResources(new DirResourceSet(webResource,"/WEB-INF/classes",path,"/"));
            //启动
            tomcat.start();
            //阻塞等待连接进入
            tomcat.getServer().await();
        } catch (LifecycleException e) {
            e.printStackTrace();
        }
    }
}
