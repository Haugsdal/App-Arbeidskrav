/*package org.example.Applikasjonsutviklingarbeidskrav.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Applikasjonsutviklingarbeidskrav.dto.RegisterUserDto;
import org.example.Applikasjonsutviklingarbeidskrav.model.User;
import org.example.Applikasjonsutviklingarbeidskrav.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class ApplikasjonsService {
    private final UserRepository userRepository;


    Create new user
    first; check to see if the email is already in use. If it is, return an error.
    second; if the first test is clean, call the user repository to create a new user entity.

    public void createUser(RegisterUserDto registerUserDto) {

        var suggestedEmail=userRepository.findByEmail(registerUserDto.getEmail()).orElse(null);

        if (suggestedEmail!=null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(registerUserDto);
        }

        User newUser=new User();
        newUser.setFirstName(registerUserDto.getFirstName());
        newUser.setLastName(registerUserDto.getLastName());
        newUser.setEmail(registerUserDto.getEmail());
        newUser.setPassword(registerUserDto.getPassword());
        newUser.setDateOfBirth(registerUserDto.getDateOfBirth());

        userRepository.save(newUser);
    }

}
*/