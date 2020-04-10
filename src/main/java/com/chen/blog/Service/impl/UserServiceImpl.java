package com.chen.blog.Service.impl;

import com.chen.blog.Service.UserService;
import com.chen.blog.dao.UserRepository;
import com.chen.blog.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Transactional
    @Override
    public User checkUser(String username, String password) {
        User user = userRepository.findAllByUsernameAndPassword(username, password);
        return user;
    }
}
