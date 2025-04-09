package org.example.mailserver.repository;

import org.example.mailserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepsoitory extends JpaRepository<User, Long> {
    
    User findUserByEmail(String email);
    
}
