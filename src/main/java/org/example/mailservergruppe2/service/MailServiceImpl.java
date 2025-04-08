package org.example.mailservergruppe2.service;

import org.example.mailservergruppe2.model.Mail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    private MailService mailService;

    @Override
    public Mail getMailById(Long id) {
        return mailService.getMailById(id);
    }

    @Override
    public void sendMail(Mail mail) {
        mailService.sendMail(mail);
    }

    @Override
    public void deleteMailById(Long id) {
        mailService.deleteMailById(id);
    }

    @Override
    public List<Mail> getAllMails() {
        return mailService.getAllMails();
    }

    @Override
    public List<Mail> getMailsByReceiver(String receiver) {
        return mailService.getMailsByReceiver(receiver);
    }

    @Override
    public List<Mail> getMailsBySender(String sender) {
        return mailService.getMailsBySender(sender);
    }
}
