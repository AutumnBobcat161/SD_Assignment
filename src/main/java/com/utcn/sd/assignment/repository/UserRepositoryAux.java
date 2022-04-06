package com.utcn.sd.assignment.repository;

import com.utcn.sd.assignment.dto.UserDto;
import com.utcn.sd.assignment.mapper.row.UserRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepositoryAux {

    private static final String GET_USER_BY_EMAIL_QUERY = "SELECT * FROM USER WHERE email = ?";
    private static final String GET_USER_BY_USERNAME_QUERY = "SELECT * FROM USER WHERE username = ?";

    private final JdbcTemplate jdbcTemplate;
    private final UserRowMapper rowMapper;

    @Autowired
    public UserRepositoryAux(JdbcTemplate jdbcTemplate , UserRowMapper rowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.rowMapper = rowMapper;
    }

    public Optional<UserDto> getUserByEmail(String email) {
        try {
            UserDto user = jdbcTemplate.queryForObject(GET_USER_BY_EMAIL_QUERY, rowMapper, email);

            assert user != null;
            return Optional.of(user);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }

    public Optional<UserDto> getUserByUsername(String username) {
        try {
            UserDto user = jdbcTemplate.queryForObject(GET_USER_BY_USERNAME_QUERY, rowMapper, username);

            assert user != null;
            return Optional.of(user);
        } catch (EmptyResultDataAccessException exception) {
            return Optional.empty();
        }
    }
}
