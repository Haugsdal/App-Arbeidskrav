package org.example.mailserver.service;

import org.example.mailserver.model.User;

import java.util.List;

public interface UserService {

    // fetch all users
    List<User> getAllUsers();

    // fetch a user by id
    User getUserById(Long id);

    // fetch a user by email
    User getUserByEmail(String email);

    // update a user
    User updateUser(Long id, User updatedUser);

    // create a user
    void createUser(User user);

    // delete a user by id
    void deleteUserById(Long id);

    // delete a user by email
    void deleteUserByEmail(String email);
}
