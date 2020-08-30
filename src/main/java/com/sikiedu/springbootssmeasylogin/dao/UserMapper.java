package com.sikiedu.springbootssmeasylogin.dao;

import com.sikiedu.springbootssmeasylogin.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Service;

@Mapper
public interface UserMapper {

    @Insert("insert into user(username,password) values(#{username},#{password})")
    int save(User user);

    @Select("select * from user where username = #{username} and password = #{password}")
    User findUserByUsernameAndPassword(User user);

    @Select("select * from user where username = #{username}")
    User isRegister(User user);
}
