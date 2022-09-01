package com.prodapt.demo.service;

import java.util.List;

import com.prodapt.demo.entity.User;
import com.prodapt.demo.entity.UserDetails;

public interface UserService {
    void saveUser(UserDetails userDetails);

    User findUserByEmail(String email);

    List<UserDetails> findAllUsers();
}