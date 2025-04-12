package org.example.mailserver.repository;

import jakarta.transaction.Transactional;
import org.example.mailserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    List<User> findAll();

    //User findById(Long id);

    User findByEmail(String email);


    void deleteUserById(Long id);

    @Modifying
    @Transactional
    @Query("DELETE FROM User u WHERE u.email = ?1")
    void deleteUserByEmail(String email);
}
