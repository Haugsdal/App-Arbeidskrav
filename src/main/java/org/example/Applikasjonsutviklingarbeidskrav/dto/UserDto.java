package org.example.Applikasjonsutviklingarbeidskrav.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class UserDto {
    /*
    Contains the fields we want to expose to the outside. In this case, we don't want to show the
    date of birth of the user and their password.
     */

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}