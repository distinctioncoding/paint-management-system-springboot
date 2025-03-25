package com.larry.paint_management_system.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.larry.paint_management_system.dto.UserDto;
import com.larry.paint_management_system.entity.User;
import com.larry.paint_management_system.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("api/users")
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(UserController.class);
    private UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers()
    {
        logger.info("Get users request initiated");
        List<User> users = userService.getAllUsers();
        logger.info("Get users request completed");
        return ResponseEntity.ok(users);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody UserDto user) {
        User newUser = userService.createUser(user);
        return ResponseEntity.status(201).body(newUser);
    }
}
