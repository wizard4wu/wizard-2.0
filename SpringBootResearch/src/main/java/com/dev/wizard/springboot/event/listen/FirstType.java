package com.dev.wizard.springboot.event.listen;

import org.springframework.context.ApplicationEvent;

public abstract class FirstType extends ApplicationEvent {

    public FirstType(Object source) {
        super(source);
    }
}
