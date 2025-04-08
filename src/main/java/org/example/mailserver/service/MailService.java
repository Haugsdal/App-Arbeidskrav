package org.example.mailserver.service;

import org.example.mailserver.model.Mail;
import org.example.mailserver.model.MyDTO;

import java.util.List;

public interface MailService {  // Your business logic
    Mail getMailById(Long id);
    void saveMail(Mail mail);
    void deleteMail(Long id);
    List<Mail> getAllMails();
    List<Mail> getAllFromEmail(String fromEmail);
    List<Mail> getAllToEmail(String toEmail);

    List<Mail> getMailsByDomain(String domain);

    List<MyDTO> getAllDTOs();

    Mail updateMail(long id, Mail updatedMail);
}
