package com.dev.wizard.domain;

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Data
@ToString(doNotUseGetters=true)
public class LoginUser {

    private String name;
    private List<String> hobbies;

    public static void main(String[] args) {
        LoginUser l = new LoginUser();
       
        System.out.println("hello");
    }

    private String getName() {

        System.out.println("getName():" + this.name);
        if (null == this.name) {
            System.out.println("this.name");
            this.name = "hello";
        }
        return this.name;
    }

}
