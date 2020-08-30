package com.sikiedu.springbootssmeasylogin.service.impl;

import com.sikiedu.springbootssmeasylogin.dao.UserMapper;
import com.sikiedu.springbootssmeasylogin.entity.User;
import com.sikiedu.springbootssmeasylogin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public boolean save(User user) {
       int rows = userMapper.save(user);
       return rows > 0 ? true:false;
    }

    @Override
    public boolean findUserByUsernameAndPassword(User user) {
        User temp=userMapper.findUserByUsernameAndPassword(user);

        return temp==null?false:true;
    }

    @Override
    public boolean isRegister(User user) {
        //看这个用户是否曾经注册过

        User register=userMapper.isRegister(user);
        //查询到了返回user,没有查询到,返回true

        return register==null?true:false;
    }




}
