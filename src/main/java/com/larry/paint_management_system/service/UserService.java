package com.larry.paint_management_system.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.larry.paint_management_system.dto.UserDto;
import com.larry.paint_management_system.entity.User;
import com.larry.paint_management_system.repository.UserRepository;

@Service
public class UserService {
    
    private UserRepository userRepository;
    public UserService(UserRepository userRepository)
    {
        this.userRepository = userRepository;
    }

    public Optional<User> getUserByUsername(String username)
    {
        return userRepository.findByUsername(username);
    }

    public List<User> getAllUsers()
    {
        return userRepository.findAll();
    }

    public User createUser(UserDto user)
    {
        User newUser = new User(user.getUsername(), user.getPassword(), user.getRole());
        return userRepository.save(newUser);
    }

    public Optional<User> getUserByUserId(Long userId)
    {
        Optional<User> user = userRepository.findById(userId);
        return user;
    }
}
