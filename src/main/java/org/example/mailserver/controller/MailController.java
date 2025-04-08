package org.example.mailserver.controller;

import org.example.mailserver.model.Mail;
import org.example.mailserver.model.MyDTO;
import org.example.mailserver.repository.MailRepository;
import org.example.mailserver.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/mail")
public class MailController {
    private final MailService mailService;

    @Autowired
    MailRepository mailRepository;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    @GetMapping("/mails")
    public ResponseEntity<List<Mail>> getAllMails(@RequestParam(required = false) String subject) {
        try {
            List<Mail> mails = (subject == null) ? mailRepository.findAll() :
                    mailRepository.findMailByContentContainingAndSubjectContains(subject, subject);
            if (mails.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(mails, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    /*
    @Autowired
    public MailController(MailService mailService) {
        this.mailService = mailService;
    }
*/
    @GetMapping("/{id}")
    public Mail getMailById(@PathVariable long id) {
        return mailService.getMailById(id);
    }

    @GetMapping
    public List<Mail> getMails() {
        return mailService.getAllMails();
    }

    @GetMapping("/from/{from}")
    public List<Mail> getAllFromMail(@PathVariable String from) {
        return mailService.getAllFromEmail(from);
    }

    @GetMapping("/to/{to}")
    public List<Mail> getAllToMail(@PathVariable String to) {
        return mailService.getAllToEmail(to);
    }

    @PostMapping
    public void addMail(@RequestBody Mail mail) {
        mailService.saveMail(mail);
    }

    @DeleteMapping("/{id}")
    public void deleteMail(@PathVariable long id) {
        mailService.deleteMail(id);
    }


    //Testing med data transfer object
    @GetMapping("/dto")
    public List<MyDTO> getAllDTOs() {
        return mailService.getAllDTOs();
    }


    @GetMapping("/domain/{domain}")
    public List<Mail> getAllFromDomain(@PathVariable String domain) {
        return mailService.getMailsByDomain(domain);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mail> updateMail(@PathVariable long id, @RequestBody Mail updatedMail) {
        try {
            Mail mail = mailService.updateMail(id, updatedMail);
            return new ResponseEntity<>(mail, HttpStatus.OK); // Return updated mail with 200 OK
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Return 404 if mail not found
        }
    }

}
