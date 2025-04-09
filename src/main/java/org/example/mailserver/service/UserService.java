package org.example.mailserver.service;

import org.example.mailserver.model.User;

import java.util.List;

public interface UserService {
    User getUserById(Long id);
    User getUserByEmail(String email);
    List<User> getAllUsers();
    void createUser(User user);

}
