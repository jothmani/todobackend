package com.jothmart.todobackend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.jothmart.todobackend.entity.User;
import com.jothmart.todobackend.service.UserService;

@RestController
@RequestMapping("/api")
public class UserController {
    
      @Autowired
    private UserService userService; 

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        System.out.println("I entered the reister API ");
       return userService.register(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        System.out.println("I entered the login API "+user);
        return userService.verify(user);
    }
}
