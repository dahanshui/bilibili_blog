package com.chen.blog.dao;

import com.chen.blog.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findAllByUsernameAndPassword(String username,String password);

}
