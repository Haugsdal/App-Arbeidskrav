package org.example.Applikasjonsutviklingarbeidskrav.model;


import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name= "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (nullable=false, name="user_id")
    private int userId;

    @Column (nullable=false, name= "first_name")
    private String firstName;

    @Column(nullable=false, name="last_name")
    private String lastName;

    @Column(nullable=false, name="email_address")
    private String email;

    @Column(nullable=false, name="password")
    private String password;

    @Column(nullable=false, name="date_of_birth")
    private String dateOfBirth;

}
