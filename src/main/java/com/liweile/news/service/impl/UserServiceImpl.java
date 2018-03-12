package com.liweile.news.service.impl;

import com.liweile.news.mapper.UserMapper;
import com.liweile.news.model.User;
import com.liweile.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public ResponseEntity<User> registerUser(User user) {
        try {
            int insert = userMapper.insert(user);
            System.out.println("insert :" + insert);
            return new ResponseEntity(userMapper.selectByUsername(user.getUsername()), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity("用户已存在", HttpStatus.BAD_REQUEST);
        }


    }

    @Override
    public ResponseEntity<User> login(String username, String password) {

        User user = userMapper.selectByUsername(username);

        if (user == null) {
            return new ResponseEntity("用户不存在", HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity(user, HttpStatus.OK);
        }

    }

    @Override
    public ResponseEntity<List<User>> getUserList() {

        List<User> users= userMapper.selectAll();
        if (users!=null&&users.size()>0){
            return new ResponseEntity<>(users,HttpStatus.OK);
        }else {
            return new ResponseEntity("没有用户",HttpStatus.BAD_REQUEST);
        }

    }
}
