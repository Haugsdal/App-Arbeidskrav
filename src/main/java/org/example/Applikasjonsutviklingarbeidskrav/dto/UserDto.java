package org.example.Applikasjonsutviklingarbeidskrav.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class UserDto {
    /*
    Contains the fields we want to expose to the outside. In this case, we don't want to show the
    date of birth of the user and their password.
     */

    //@Schema(accessMode = Schema.AccessMode.READ_ONLY);
    private Long userId;

    private String firstName;
    private String lastName;
    private String email;
}