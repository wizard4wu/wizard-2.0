package com.dev.wizard.springboot.cyclebean;

import lombok.Data;

@Data
public class JdkObjectA {
    private String name;
    private JdkObjectB jdkObjectB;

    public static void main(String[] args) {
        JdkObjectA jdkObjectA = new JdkObjectA();
        JdkObjectB jdkObjectB = new JdkObjectB();
        jdkObjectA.setJdkObjectB(jdkObjectB);
        jdkObjectB.setJdkObjectA(jdkObjectA);
        System.out.println(jdkObjectA.getJdkObjectB());

    }
}
