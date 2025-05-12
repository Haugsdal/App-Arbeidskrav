package org.example.Applikasjonsutviklingarbeidskrav.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.coyote.Response;
import org.example.Applikasjonsutviklingarbeidskrav.dto.RegisterUserDto;
import org.example.Applikasjonsutviklingarbeidskrav.dto.UserDto;
import org.example.Applikasjonsutviklingarbeidskrav.mapper.UserMapper;
import org.example.Applikasjonsutviklingarbeidskrav.repository.UserRepository;
import org.example.Applikasjonsutviklingarbeidskrav.service.ApplikasjonsService;
import org.example.Applikasjonsutviklingarbeidskrav.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController //Creates a bean that is managed by spring
@RequestMapping("/app")
@Tag(name="ApplikasjonsController", description="API for managing users and activitites")
@RequiredArgsConstructor
public class ApplikasjonsController {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    @Autowired
    private final ApplikasjonsService applikasjonsService;

    //Get user by email
    @GetMapping("/email/{email}")
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

        //Lastly, we return the information in the user dto.
        return ResponseEntity.ok(userMapper.toDto(user));
    }

    /*
    Create user
    Collect information from JSON body and insert it into a dto. Then, call service layer and pass
    the dto to it. Respond with request has been completed and the information about the user,
    excluding the password and date of birth.
    */

    @PostMapping("/createUser")
    @Operation(summary="Post user", description="Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses({
            @ApiResponse(responseCode = "500", description = "Internal Server Error")
    })
    public ResponseEntity<UserDto> createUser (@Valid @RequestBody RegisterUserDto registerUserDto,
                                               UriComponentsBuilder uriBuilder) {
        var createdUser=applikasjonsService.createUser(registerUserDto);
        var uri=uriBuilder.path("/app/{email}").buildAndExpand(createdUser.getEmail()).toUri();

        return ResponseEntity.created(uri).body(createdUser);
    }

    /*
    Deleting User
    - Should also delete all activities registered on that account

    First, check if the user exists. Then, check if user has any registered activities in the
    activities table. If they do, create a list of them and delete every object by iterating
    through the list. Lastly, delete the user from the user table.
    */
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {
        var user=userRepository.findByEmail(email).orElse(null);
        if (user==null) {
            return ResponseEntity.notFound().build();
        }
        userRepository.delete(user);
        return ResponseEntity.noContent().build();
    }

}
