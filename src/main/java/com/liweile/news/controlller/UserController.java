package com.liweile.news.controlller;

import com.liweile.news.model.User;
import com.liweile.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/register")
    public ResponseEntity<User> register(@RequestParam String username, @RequestParam String password){

        return userService.registerUser(new User(username,password));
    }

   @RequestMapping("/login")
    public ResponseEntity<User> login(@RequestParam String username, @RequestParam String password){
      return userService.login(username,password);
   }


   @RequestMapping("/userlist")
    public ResponseEntity<List<User>> getUserList(){

       return userService.getUserList();
   }
   @RequestMapping("/updateclassname")
    public void setClassName(@RequestParam String username, @RequestParam String classname){

        userService.updateClassName( username, classname);
   }
    @RequestMapping("/updatename")
    public void setName(@RequestParam String username, @RequestParam String name){

        userService.updateName( username, name);
   }






}
