package com.wizard.kafka.interceptor;

import org.springframework.kafka.core.ProducerPostProcessor;

public class MyProducerPostProcessor implements ProducerPostProcessor {
    @Override
    public Object apply(Object o) {
        return null;
    }
}
