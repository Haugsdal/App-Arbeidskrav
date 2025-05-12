package org.example.Applikasjonsutviklingarbeidskrav.repository;

import org.example.Applikasjonsutviklingarbeidskrav.dto.UserDto;
import org.example.Applikasjonsutviklingarbeidskrav.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;


/*
    User repository is used for interacting with the database without having to write SQL.

    CRUD - Create, Read, Update and Delete
    
    need find, save, and delete
 */

public interface UserRepository extends JpaRepository<User, Long> {

    //Get all
    //List<UserDto> findAll();

    //Find user by email
    Optional<User> findByEmail(String email);

    //Save new user
    User save(User user);

}
