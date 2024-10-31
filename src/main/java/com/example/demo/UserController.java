package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    
    private final List<User> users = new ArrayList<>();

    public UserController() {
        // Sample users
        users.add(new User("Aradhya"));
        users.add(new User("Arya"));
        users.add(new User("Aparna"));
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return users;
    }
}
