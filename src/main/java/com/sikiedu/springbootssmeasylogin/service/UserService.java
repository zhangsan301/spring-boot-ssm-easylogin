package com.sikiedu.springbootssmeasylogin.service;

import com.sikiedu.springbootssmeasylogin.entity.User;

public interface UserService {

    boolean save(User user);

    boolean findUserByUsernameAndPassword(User user);


    boolean isRegister(User user);
}
