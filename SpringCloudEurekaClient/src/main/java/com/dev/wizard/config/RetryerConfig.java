package com.dev.wizard.config;

import feign.RetryableException;
import feign.Retryer;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Configuration
public class RetryerConfig implements Retryer {
    @Override
    public void continueOrPropagate(RetryableException e) {
        throw e;
    }

    @Override
    public Retryer clone() {
        return new Default(100, TimeUnit.SECONDS.toMillis(1), 5);
    }
}
