package com.dev.wizard.research.proxy.domain;

import lombok.Data;


@Data
public class User extends People{

    private String name;

    public static void main(String[] args) {
        User user = new User();
        user.setName("ss");
        copy(user);
        System.out.println(user.getName());
    }


    @Override
    public void sleep() {
        System.out.println("public User sleep");
    }

    private static void copy(User user){

        User usere = new User();
        usere.setName("ddd");
        user = usere;
    }
}
