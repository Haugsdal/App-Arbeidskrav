package org.example.Applikasjonsutviklingarbeidskrav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data //Combines the getter and setter annotation

public class RegisterUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
}