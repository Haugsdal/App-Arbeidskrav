package org.example.mailservergruppe2.controller;

import org.example.mailservergruppe2.model.Mail;
import org.example.mailservergruppe2.service.MailService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/mail")
public class MailController {
    private final MailService mailService;

    public MailController(MailService mailService) {
        this.mailService = mailService;
    }

    //---------- READ ----------
    @GetMapping
    public List<Mail> getAllMails() {
        return mailService.getAllMails();
    }

    @GetMapping("/{id}")
    public Mail getMailById(Long id) {
        return mailService.getMailById(id);
    }

    @GetMapping("/receiver{receiver}")
    public Mail getMailsByReceiver(String receiver) {
        return mailService.getMailByReceiver(receiver);
    }

    @GetMapping("/sender{sender}")
    public Mail getMailBySender(String sender) {
        return mailService.getMailBySender(sender);
    }



    //----------- POST -------------
    @PostMapping
    public void sendMail(Mail mail) {
        mailService.sendMail(mail);
    }

    //----------- DELETE ------------
    @DeleteMapping
    public void deleteMailById(Long id) {
        mailService.deleteMailById(id);
    }


}
