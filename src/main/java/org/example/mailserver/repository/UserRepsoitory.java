package org.example.mailserver.repository;

import org.example.mailserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepsoitory extends JpaRepository<User, Long> {

}
