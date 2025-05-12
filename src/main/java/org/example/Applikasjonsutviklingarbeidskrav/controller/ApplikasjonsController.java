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

    @Autowired
    private final ApplikasjonsService applikasjonsService;

    /*
    Get user by email
    */
    @GetMapping("/email/{email}")
    @Operation(summary="Get user by email", description="Get user by email address")
    public ResponseEntity<UserDto> getUserByEmail(@PathVariable String email) {

        var user = applikasjonsService.getUserByEmail(email);

        return ResponseEntity.ok(user);
    }

    /*
    Create user
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
    Delete user and all activities they have registered
     */
    @DeleteMapping("/{email}")
    public ResponseEntity<Void> deleteUser(@PathVariable String email) {

        applikasjonsService.deleteUser(email);

        return ResponseEntity.noContent().build();
    }
}
