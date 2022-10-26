package com.dev.wizard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
public class SpringBootStarter {
    public static void main(String[] args) {
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "SpringBootResearch\\cglib");
        SpringApplication.run(SpringBootStarter.class, args);
    }
}
