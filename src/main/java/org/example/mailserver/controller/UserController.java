package org.example.mailserver.controller;

import org.example.mailserver.model.User;
import org.example.mailserver.repository.UserRepsoitory;
import org.example.mailserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepsoitory userRepsoitory;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/id/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/email/{email}")
    public User getUserByEmail(@PathVariable String email) {
        System.out.println("Email: " + email);
        return userService.getUserByEmail(email);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //----- POST ----
    @PostMapping
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
}
