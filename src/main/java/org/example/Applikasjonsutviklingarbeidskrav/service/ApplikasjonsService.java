package org.example.Applikasjonsutviklingarbeidskrav.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.example.Applikasjonsutviklingarbeidskrav.dto.RegisterUserDto;
import org.example.Applikasjonsutviklingarbeidskrav.dto.UserDto;
import org.example.Applikasjonsutviklingarbeidskrav.exception.EmailAlreadyExistsException;
import org.example.Applikasjonsutviklingarbeidskrav.exception.GlobalExceptionHandler;
import org.example.Applikasjonsutviklingarbeidskrav.mapper.UserMapper;
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
    private final UserMapper userMapper;

    /*
    Get user by email
    Calls the user repository to find the user by their email. The user information is then
    saved in a dto, before the program checks if the dto is null, which means that the user has
    not been found. In that case, the program throws an error to inform the system user that the
    user doesn't exist. Lastly, the program sends the dto to the controller, and the controller
    passes it to the system user.
     */
    public UserDto getUserByEmail (String email) {

        var user=userRepository.findByEmail(email).orElse(null);

        if (user==null) {
            throw new EntityNotFoundException("The user does not exist.");
        }

        return userMapper.toDto(user);
    }

    /*
    Create new user
    first; check to see if the email is already in use. If it is, return an error.
    second; if the first test is clean, call the user repository to create a new user entity.
    */
    public UserDto createUser(RegisterUserDto registerUserDto) {

        var suggestedEmail=userRepository.findByEmail(registerUserDto.getEmail()).orElse(null);

        if (suggestedEmail!=null) {
            throw new EmailAlreadyExistsException("Email is already in use");
        }

        var newUserObject=userMapper.toUserObject(registerUserDto);
        userRepository.save(newUserObject);

        var createdObject=userMapper.toDto(newUserObject);
        return createdObject;

    }

    /*
    Deleting User

    First, get the user. Then, check if the user exists. If the user doesn't
    exist, throw an error. If the user does exist, delete the user from
    the user table.

    Deleting a user should delete all activities registered on the user. This can
    be done by adding ON CASCADE DELETE in the activity table declaration in the
    database itself.
    */
    public void deleteUser(String email) {
        var user=userRepository.findByEmail(email).orElse(null);
        if (user==null) {
            //throw error user not found
        }
        userRepository.delete(user);
    }


}
