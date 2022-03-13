package com.utcn.sd.assignment.mapper.row;

import com.utcn.sd.assignment.dto.UserDto;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class UserRowMapper implements RowMapper<UserDto> {

    @Override
    public UserDto mapRow(ResultSet resultSet, int i) throws SQLException {

        return new UserDto.UserBuilder()
                .idUser(resultSet.getInt("id_user"))
                .username(resultSet.getString("username"))
                .password(resultSet.getString("password"))
                .email(resultSet.getString("email"))
                .idRole(resultSet.getInt("id_role"))
                .isBanned(resultSet.getBoolean("is_banned"))
                .build();
    }
}