package org.example.mailserver.repository;

import org.example.mailserver.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {

    // Fetch mails by the 'toEmail' field
    List<Mail> findAllByToEmail(String toEmail);

    // Fetch mails by the 'fromEmail' field
    List<Mail> findAllByFromEmail(String fromEmail);

    // Filter mails by content and subject (if applicable)
    List<Mail> findMailByContentContainingAndSubjectContains(String str1, String str2);

    // Custom query to get mails by domain in the 'fromEmail'
    @Query(value = "SELECT * FROM mails WHERE from_email LIKE %:domain%", nativeQuery = true)
    List<Mail> getMailsByDomain(String domain);
}




/*
package org.example.mailserver.repository;

import org.example.mailserver.model.Mail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MailRepository extends JpaRepository<Mail, Long> {

    List<Mail> findAllByToEmail (String toEmail);

    List<Mail> findAllByFromEmail (String fromEmail);

    List<Mail> findAll();
    /*
    //Example (13 ish min)
    List<Mail> findMailByContentContainingAndSubjectContains (String str1, String str2);

    //Or you can make a Query
    @Query(value = "SELECT * FROM mails WHERE from_email LIKE %:domain", nativeQuery = true)
    List<Mail> getMailsByDomain (String domain); // so whenever this function is called the query will be used
}

*/