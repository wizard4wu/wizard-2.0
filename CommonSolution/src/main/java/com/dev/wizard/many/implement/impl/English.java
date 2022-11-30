package com.dev.wizard.many.implement.impl;

import com.dev.wizard.many.implement.service.People;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 3)
public class English implements People {
    @Override
    public void speak() {
        System.out.println("英国人说英语");
    }

    @Override
    public String getType() {
        return "english";
    }


}
