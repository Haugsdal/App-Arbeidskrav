package org.example.mailserver.service;

import org.example.mailserver.model.User;
import org.example.mailserver.repository.UserRepsoitory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepsoitory userRepsoitory;

    // ------ GET -------
    @Override
    public User getUserById(Long id) {
        return userRepsoitory.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepsoitory.findUserByEmail(email);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepsoitory.findAll();
    }

    //------- POST -------
    @Override
    public void createUser(User user) {
        userRepsoitory.save(user);
    }


}
