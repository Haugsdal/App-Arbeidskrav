package org.example.mailservergruppe2.repository;

import org.example.mailservergruppe2.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MailRepository extends JpaRepository<Mail, Long> {
}
