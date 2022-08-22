package com.dev.wizard.research.proxy.domain;

import lombok.Data;


@Data
public class User extends People{

    private String name;

    public static void main(String[] args) {
        User user = new User();

        copy(user);

    }


    @Override
    public void sleep() {
        System.out.println("public User sleep");
    }

    private static void copy(User user){

    }
}
