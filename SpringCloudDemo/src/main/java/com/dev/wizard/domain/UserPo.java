package com.dev.wizard.domain;

import lombok.Data;

import java.time.Instant;

@Data
public class UserPo {
    private Long id;
    private String email;
    private String name;
    private int age;
    private int sex;
    private String phoneNumber;
    private Instant createTime;
    private Instant updatedTime;
}
