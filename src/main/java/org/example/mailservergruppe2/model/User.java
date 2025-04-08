package org.example.mailservergruppe2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "users") // fikk problemer på grunn av at user er reservert ord i postgresql
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(unique = true, nullable = false)
    private String email;

    private String username;
    private String password;

    @OneToMany(mappedBy = "sender")
    private List<Mail> sentEmails;

    @OneToMany(mappedBy = "recipient")
    private List<Mail> receivedEmails;
}
