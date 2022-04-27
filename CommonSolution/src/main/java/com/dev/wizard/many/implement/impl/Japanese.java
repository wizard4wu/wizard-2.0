package com.dev.wizard.many.implement.impl;

import com.dev.wizard.many.implement.service.People;
import org.springframework.stereotype.Service;

@Service
public class Japanese implements People {
    @Override
    public void speak() {
        System.out.println("日本人说日语");
    }
}
