package com.dev.wizard.domain.vo;

import com.dev.wizard.domain.User;
import lombok.Data;

@Data
public class UserVo {

    private Long id;
    private String email;
    private String name;
    private int age;
    private String sex;
    private String phoneNumber;

    public User to(){
        User user = new User();
        user.setId(this.getId());
        user.setEmail(this.getEmail());
        user.setName(this.getName());
        user.setAge(this.getAge());
        user.setSex(this.getSex());
        user.setPhoneNumber(this.getPhoneNumber());
        return user;
    }
}
