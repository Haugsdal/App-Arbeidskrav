package org.example.mailserver.service;

import org.example.mailserver.model.Mail;
import org.example.mailserver.model.MyDTO;
import org.example.mailserver.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private MailRepository mailRepository;

    @Override
    public Mail getMailById(Long id) {
        return mailRepository.findById(id).orElse(null);
    }

    @Override
    public void saveMail(Mail mail) {
        mailRepository.save(mail);
    }

    @Override
    public void deleteMail(Long id) {
        mailRepository.deleteById(id);
    }

    @Override
    public List<Mail> getAllMails() {
        return mailRepository.findAll();
    }

    @Override
    public List<Mail> getAllFromEmail(String fromEmail) {
        return mailRepository.findAllByFromEmail(fromEmail);
    }

    @Override
    public List<Mail> getAllToEmail(String toEmail) {
        return mailRepository.findAllByToEmail(toEmail);
    }

    @Override
    public List<Mail> getMailsByDomain(String domain) {
        return mailRepository.getMailsByDomain(domain);
    }

    @Override
    public List<MyDTO> getAllDTOs() {
        return List.of();
    }


    public Mail updateMail(long id, Mail updatedMail) {
        return mailRepository.findById(id)
                .map(mail -> {
                    // Update the fields of the existing mail
                    mail.setSubject(updatedMail.getSubject());
                    mail.setFromEmail(updatedMail.getFromEmail());
                    mail.setToEmail(updatedMail.getToEmail());
                    mail.setContent(updatedMail.getContent());
                    return mailRepository.save(mail);  // Save the updated mail
                })
                .orElseThrow(() -> new RuntimeException("Mail not found with id: " + id));  // Throw exception if not found
    }
}


/*
package org.example.mailserver.service;

import org.example.mailserver.model.Mail;
import org.example.mailserver.model.MyDTO;
import org.example.mailserver.repository.MailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MailServiceImpl implements MailService {
    private final MailRepository mailRepository;

    @Autowired
    public MailServiceImpl(MailRepository mailRepository) {
        this.mailRepository = mailRepository;
    }

    @Override
    public Mail getMailById(Long id) {
        Optional<Mail> mail = mailRepository.findById(id);
        return mail.orElse(null);
        //return optionalProduct.orElse(null);
    }

    @Override
    public void saveMail(Mail mail) {
        System.out.println("Saving Mail: " + mail);
        mailRepository.save(mail);
    }

    @Override
    public void deleteMail(Long id) {
        mailRepository.deleteById(id);
    }

    @Override
    public List<Mail> getAllMails() {
        return mailRepository.findAll();
    }

    @Override
    public List<Mail> getAllFromEmail(String fromEmail) {
        return mailRepository.findAllByFromEmail(fromEmail);
    }

    @Override
    public List<Mail> getAllToEmail(String toEmail) {
        return mailRepository.findAllByToEmail(toEmail);
    }

    @Override
    public List<Mail> getMailsByDomain(String domain) {
        return mailRepository.getMailsByDomain(domain);
    }

    @Override
    public List<MyDTO> getAllDTOs() {
        ArrayList<MyDTO> myDTOs = new ArrayList<>();
        myDTOs.add(new MyDTO("n1","l1"));
        myDTOs.add(new MyDTO("n2","l2"));
        return myDTOs;
    }
}

*/
