package com.dev.wizard.springboot.cyclebean;

import lombok.Data;



public class JdkObjectB {
    private String name;
    private JdkObjectA jdkObjectA;


    public void setJdkObjectA(final JdkObjectA jdkObjectA) {
        this.jdkObjectA = jdkObjectA;
    }
}
