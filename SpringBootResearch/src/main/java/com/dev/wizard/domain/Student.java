package com.dev.wizard.domain;

import lombok.Data;
import org.springframework.context.ApplicationEvent;

import java.time.Clock;

@Data
public class Student extends ApplicationEvent {

    private String name;

    private int age;

    public Student(Object source, String name, int age) {
        super(source);
        this.name = name;
        this.age = age;
    }
}
