package com.dev.wizard.proxy.agent;


import org.springframework.stereotype.Service;

@Service
public class TestService {

    public void first(){
        System.out.println("first");
        this.second();

    }

    public void second(){
        System.out.println("second");
    }
}
