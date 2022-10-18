package com.dev.wizard.domain;


import lombok.Data;
import org.springframework.context.ApplicationEvent;

@Data
public class CurrentUser extends ApplicationEvent {

    private String name;
    private int age;

    public CurrentUser(Object source, String name, int age){
        super(source);
        this.name = name;
        this.age = age;
    }
}
