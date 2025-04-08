package org.example.mailserver.model;

import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyDTO {

    @Id
    private Long id;
    private String name;
    private String lastName;

    public MyDTO(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
}
