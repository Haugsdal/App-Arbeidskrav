package org.example.mailservergruppe2.service;

import org.example.mailservergruppe2.model.Mail;

import java.util.List;

public interface MailService {
    Mail getMailById(Long id);
    Mail getMailByReceiver(String receiver);
    Mail getMailBySender(String sender);
    void sendMail(Mail mail);
    void deleteMailById(Long id);
    List<Mail> getAllMails();
    List<Mail> getMailsByReceiver(String receiver);
    List<Mail> getMailsBySender(String sender);
}
