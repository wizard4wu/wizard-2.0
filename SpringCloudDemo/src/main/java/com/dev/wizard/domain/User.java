package com.dev.wizard.domain;

import lombok.Data;

@Data
public class User {
    private Long id;
    private String email;
    private String name;
    private int age;
    private String sex;
    private String phoneNumber;

    public UserPo toPo(){
        UserPo userPo = new UserPo();
        userPo.setId(this.getId());
        userPo.setEmail(this.getEmail());
        userPo.setName(this.getName());
        userPo.setAge(this.getAge());
        userPo.setSex("男".equals(this.getSex())? 1:0);
        userPo.setPhoneNumber(this.getPhoneNumber());
        return userPo;
    }
}
