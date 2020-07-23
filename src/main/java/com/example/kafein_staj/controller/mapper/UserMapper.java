package com.example.kafein_staj.controller.mapper;

import com.example.kafein_staj.datatransferobject.UserDTO;
import com.example.kafein_staj.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface UserMapper {
    @Mapping(target = "phone", source = "phoneNumber")
    UserDTO userToUserDTO(User userEntity);

    @Mapping(target = "phoneNumber", source = "phone")
    User userDTOToUser(UserDTO userDTO);
}
