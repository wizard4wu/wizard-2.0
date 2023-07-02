package com.dev.wizard;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@SpringBootApplication
@EnableAspectJAutoProxy
@EnableAsync
@EnableScheduling
public class SpringBootWithDockerStarter {
    public static void main(String[] args) {
        System.setProperty("jdk.proxy.ProxyGenerator.saveGeneratedFiles", "true");
         System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "SpringBootWithDocker\\cglib");
        SpringApplication.run(SpringBootWithDockerStarter.class, args);

    }

}
