package org.example.Applikasjonsutviklingarbeidskrav.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.Applikasjonsutviklingarbeidskrav.dto.RegisterUserDto;
import org.example.Applikasjonsutviklingarbeidskrav.dto.UserDto;
import org.example.Applikasjonsutviklingarbeidskrav.repository.UserRepository;
//import org.example.Applikasjonsutviklingarbeidskrav.service.ApplikasjonsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController //Creates a bean that is managed by spring
@RequestMapping("/app")
@Tag(name="ApplikasjonsController", description="API for managing users and activitites")
@RequiredArgsConstructor
public class ApplikasjonsController {

    private final UserRepository userRepository;
    //private final ApplikasjonsService applikasjonsService;

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

        //To protect the information, we use a dto to limit the information displayed for the user
        var userDto = new UserDto(user.getUserId(), user.getFirstName(), user.getLastName(), user.getEmail());

        //Lastly, we return the information in the user dto.
        return ResponseEntity.ok(userDto);
    }



    /*
    Create user
    Collect information from JSON body and insert it into a dto. Then, call service layer and pass
    the dto to it. Respond with request has been completed.

    @PostMapping("createUser")
    @Operation(summary="Post user", description="Create user")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponses(
            @ApiResponse(responseCode="500", description="Internal Server Error")
    )
    public ResponseEntity<RegisterUserDto> createUser (@Valid @RequestBody RegisterUserDto registerUserDto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(applikasjonsService.createUser(registerUserDto));
    }


     */

}
