package org.example.mailservergruppe2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Mail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sender_email", referencedColumnName = "email")
    private User sender;

    @ManyToOne
    @JoinColumn(name = "recipient_email", referencedColumnName = "email")
    private User recipient;

    private String subject;
    private String content;
    private LocalDateTime timestamp;
}
