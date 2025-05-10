package org.example.Applikasjonsutviklingarbeidskrav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data //Combines the getter, setter  and other annotations
public class RegisterUserDto {
    private Long userId;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
}