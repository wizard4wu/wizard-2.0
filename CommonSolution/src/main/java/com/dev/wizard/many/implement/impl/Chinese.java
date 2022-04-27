package com.dev.wizard.many.implement.impl;

import com.dev.wizard.many.implement.service.People;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 5)
public class Chinese implements People {
    @Override
    public void speak() {
        System.out.println("中国人说汉语");
    }
}
