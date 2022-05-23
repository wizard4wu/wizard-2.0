package com.dev.wizard.domain;

import lombok.Data;

@Data
public class Person {
    private String id;

    private String domainName;

    @Data
    public static class Teacher{
        private String id;

        private String name;

        private int age;

    }

}
