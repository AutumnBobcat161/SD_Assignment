package com.utcn.sd.assignment.mapper;

import com.utcn.sd.assignment.dto.UserDto;
import com.utcn.sd.assignment.model.User;

public class UserMapper {

    public static User toEntity(UserDto userDto) {
        return new User.UserBuilder()
                .idUser(userDto.getIdUser())
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .idRole(userDto.getIdRole())
                .isBanned(userDto.getBanned())
                .score(userDto.getScore())
                .build();
    }

    public static UserDto toDto(User user) {
        return new UserDto.UserBuilder()
                .idUser(user.getIdUser())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .idRole(user.getIdRole())
                .isBanned(user.getBanned())
                .score(user.getScore())
                .build();
    }
}
