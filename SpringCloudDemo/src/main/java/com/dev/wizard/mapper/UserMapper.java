package com.dev.wizard.mapper;

import com.dev.wizard.domain.UserPo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    @Select("select * from my_user where id = #{id}")
    UserPo getUserById(Long id);

    @Insert("insert into my_user(name, email, age, phone_number, sex) value(#{name}, #{email}, #{age}, #{phoneNumber}, #{sex})")
    boolean insertUser(UserPo userPo);
}
