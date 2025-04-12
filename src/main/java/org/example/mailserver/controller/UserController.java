package org.example.mailserver.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.example.mailserver.model.User;
import org.example.mailserver.repository.UserRepository;
import org.example.mailserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@Tag(name = "User Controller")
@CrossOrigin(origins = "http://localhost:8081")
@RestController
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    @Autowired
    UserRepository userRepository;
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // ------ GET -------
    @GetMapping("/get-id/{id}")
    @Operation(summary="Get user by ID", description = "Get user by ID")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/get-email/{email}")
    @Operation(summary="Get user by email", description = "Get user by email")
    public User getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @GetMapping("/get/")
    @Operation(summary="Get all users", description = "List all users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    //----- PUT ----
    // @PutMapping("/{id}")
    // @Operation(summary="Update user", description = "Update user details")
    //public void updateUser(@RequestBody User user) {userService.updateUser(user);}

    @PutMapping("/{id}")
    @Operation(summary="Update user", description = "Update user details")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User updatedUser) {
       try {
            User user = userService.updateUser(id, updatedUser);
            return new ResponseEntity<>(user, HttpStatus.OK); //return update and code 200 - OK
       } catch (RuntimeException e) {
           return new ResponseEntity<>(HttpStatus.NOT_FOUND); //returning 404 not found if .. yknow
       }
    }

    //----- POST ----
    @PostMapping
    @Operation(summary="Create user", description = "Create a new user")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    //----- DELETE ----
    @DeleteMapping("/delete-id/{id}")
    @Operation(summary="Delete user by ID", description = "Delete a user using ID")
    public void deleteUserById(@PathVariable Long id) { userService.deleteUserById(id);}

    @DeleteMapping("/delete-email/{email:.+}") //for spesialtegn
    @Operation(summary="Delete user by email", description = "Delete a user using email")
    public void deleteUserByEmail(@PathVariable String email) { userService.deleteUserByEmail(email);}
}
