package org.example.Applikasjonsutviklingarbeidskrav.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;
import org.example.Applikasjonsutviklingarbeidskrav.dto.RegisterUserDto;
import org.example.Applikasjonsutviklingarbeidskrav.dto.UserDto;
import org.example.Applikasjonsutviklingarbeidskrav.model.User;
import org.example.Applikasjonsutviklingarbeidskrav.repository.UserRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Creates a bean that is managed by spring
@AllArgsConstructor
@RequestMapping("/app")
public class ApplikasjonsController {

    private final UserRepository userRepository;

    //Get user by email
    @GetMapping("getEmail/{email}")
    @Operation(summary="Get user by email", description="Get user by email address")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {//pathvariable captures dynamic values from the request URL

        //Calls userRepository to use the method to find the user by their email. Returns null if not found.
        var user=userRepository.findByEmail(email).orElse(null);

        //Checking if user is an actual user or null
        if (user==null) {
            //If user is null, the page will respond with 404 - the standard code for object not found.
            //Response entity is a class with many standard responses/objects that are easy to implement and manage.
            return ResponseEntity.notFound().build();
        }

        //To protect the information, we use a dto to limit the information displayed for the user.
        var userDto = new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail());

        //Lastly, we return the information in the user dto.
        return ResponseEntity.ok(userDto);
    }

    /*

    //Create user:3
    @PostMapping("createUser")
    @Operation(summary="Create user", description="Post user")
    public UserDto createUser(@RequestBody RegisterUserDto newUser) {
        //Check if user exists in database
        var found=userRepository.findByEmail(user.getEmail).orElse(null);

        //Checking if the email is already in use
        if (found!=null) {
            //If the email exists, the page will respond with code 400 for bad request.
            return ResponseEntity.badRequest().build();
        }

        //If the email isn't in use, create user using dto

        //If it doesn't exist, create user using dto (the dto has rules for what is allowed^^)



        return ResponseEntity.ok(userRepository.save(userDto));
    }
    */

}
