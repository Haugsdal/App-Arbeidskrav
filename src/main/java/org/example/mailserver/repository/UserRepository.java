package org.example.mailserver.repository;

import jakarta.transaction.Transactional;
import org.example.mailserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


/*
    User repository is used for interacting with the database without having to write SQL.

    CRUD - Create, Read, Update and Delete
    
    need find, save, and delete
 */

public interface UserRepository extends JpaRepository<User, Long> {

    //Find user by email
    User findByEmail(String email);

    //Save new user
    User save(User user);

    //Delete user by email
    void deleteByEmail(String email);
}
