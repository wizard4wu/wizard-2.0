package com.dev.wizard.research.proxy.domain;

import com.google.common.eventbus.Subscribe;


public class People {

    private String name;

    @Subscribe
    public void sleep(){
        System.out.println("public People sleep");
    }

    @Subscribe
    private void eat(){
        System.out.println("private People eat");
    }
}
