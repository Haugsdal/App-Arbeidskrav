package org.example.Applikasjonsutviklingarbeidskrav.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
* DTO used for encapsulating the data used for registering a new
* user.
*
* @Data combines the getter and setter annotations, in addition to many
* other annotations.
*
* The id field is generated when a new user is created. It is therefore
* not included in the dto.
* */


@AllArgsConstructor
@Data
public class RegisterUserDto {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String dateOfBirth;
}