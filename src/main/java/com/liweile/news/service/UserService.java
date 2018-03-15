package com.liweile.news.service;

import com.liweile.news.model.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {


    ResponseEntity<User> registerUser(User user);

    ResponseEntity login(String username, String password);

    ResponseEntity<List<User>> getUserList();

    void updateClassName(String username, String classname);

    void updateName(String username, String name);
}
