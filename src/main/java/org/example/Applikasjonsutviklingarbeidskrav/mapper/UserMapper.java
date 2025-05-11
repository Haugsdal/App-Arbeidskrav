package org.example.Applikasjonsutviklingarbeidskrav.mapper;

import org.example.Applikasjonsutviklingarbeidskrav.dto.*;
import org.example.Applikasjonsutviklingarbeidskrav.model.User;
import org.mapstruct.*;

@Mapper (componentModel="spring",
            nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface UserMapper {
    UserDto toDto(User user);

    //Method that returns a user object, and uses a registerUserDto object
    User toUserObject(RegisterUserDto registerUserDto);


}