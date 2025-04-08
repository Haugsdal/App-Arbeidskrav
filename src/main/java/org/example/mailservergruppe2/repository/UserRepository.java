package org.example.mailservergruppe2.repository;

import org.example.mailservergruppe2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
