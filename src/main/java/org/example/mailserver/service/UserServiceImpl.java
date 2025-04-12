package org.example.mailserver.service;

import org.example.mailserver.model.User;
import org.example.mailserver.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    // ------ GET -------
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    //------- PUT -------
    @Override
    public User updateUser(Long id,User updatedUser) {
        return userRepository.findById(id).map(
                user -> {
                    user.setUsername(updatedUser.getUsername());
                    user.setEmail(updatedUser.getEmail());
                    user.setPassword(updatedUser.getPassword());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new RuntimeException("User not found" + id));
    }


    //------- POST -------
    @Override
    public void createUser(User user) {
        userRepository.save(user);
    }

    //------- DELETE -------
    @Override
    public void deleteUserById(Long id) { userRepository.deleteById(id);}

    @Override
    public void deleteUserByEmail(String email) { userRepository.deleteUserByEmail(email);}
}
