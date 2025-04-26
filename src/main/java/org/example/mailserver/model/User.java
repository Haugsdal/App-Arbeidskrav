package org.example.mailserver.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name= "user")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long userid;

    @Column (nullable=false, name= "first_name")
    private String firstname;

    @Column(nullable=false, name="last_name")
    private String lastname;

    @Column(nullable=false, name="email_address")
    private String email;

    @Column(nullable=false, name="password")
    private String password;

    @Column(nullable=false, name="date_of_birth")
    private String dateOfBirth;

}
