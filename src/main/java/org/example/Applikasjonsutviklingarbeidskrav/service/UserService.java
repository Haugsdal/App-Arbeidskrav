package org.example.Applikasjonsutviklingarbeidskrav.service;

import org.example.Applikasjonsutviklingarbeidskrav.dto.UserDto;
import org.example.Applikasjonsutviklingarbeidskrav.model.User;

import java.util.List;

public interface UserService {

    //get all users
    List<UserDto> getUsers();
}
