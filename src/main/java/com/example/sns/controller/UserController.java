package com.example.sns.controller;

import com.example.sns.model.User;
import com.example.sns.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public String registerUser(@RequestBody User user) {
        userRepository.save(user);
        return "User registered successfully!";
    }

    @PostMapping("/login")
    public String loginUser(@RequestBody User user) {
        User existingUser = userRepository.findByUsernameAndPassword(user.getUsername(), user.getPassword());
        if (existingUser != null) {
            return "User logged in successfully!";
        } else {
            return "Invalid username or password!";
        }
    }

    @GetMapping("/users/{id}")
    public User getUserById(@PathVariable int id) {
        return userRepository.findById(id);
    }

    @PutMapping("/users/{id}")
    public String updateUser(@PathVariable int id, @RequestBody User user) {
        User existingUser = userRepository.findById(id);
        if (existingUser != null) {
            existingUser.setUsername(user.getUsername());
            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setProfilePicture(user.getProfilePicture());
            userRepository.update(existingUser);
            return "User updated successfully!";
        } else {
            return "User not found!";
        }
    }
}
