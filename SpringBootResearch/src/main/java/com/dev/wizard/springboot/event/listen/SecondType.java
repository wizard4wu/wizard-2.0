package com.dev.wizard.springboot.event.listen;

import org.springframework.context.ApplicationEvent;

public abstract class SecondType extends ApplicationEvent {
    public SecondType(Object source) {
        super(source);
    }
}
