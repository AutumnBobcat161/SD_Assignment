package com.utcn.sd.assignment.service;

import com.utcn.sd.assignment.model.User;
import com.utcn.sd.assignment.repository.UserRepository;
import com.utcn.sd.assignment.repository.UserRepositoryAux;
import com.utcn.sd.assignment.service.user.UserServiceImpl;
import com.utcn.sd.assignment.util.MapperUtil;
import com.utcn.sd.assignment.util.UserServiceUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.openMocks;

public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private UserRepositoryAux userRepositoryAux;

    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    void setup() {
        userRepository = Mockito.mock(UserRepository.class);
        openMocks(this);
        userService = new UserServiceImpl(userRepository, userRepositoryAux);
    }

    @Test
    public void whenGetAllUser_thenReturnAllUsers() {
        when(userRepository.findAll()).thenReturn(UserServiceUtil.userDtoList);

        List<User> userResponseList = userService.getAllUsers();

        assertEquals(userResponseList.get(0), MapperUtil.userExpected);
        assertEquals(userResponseList.get(1), MapperUtil.user);
    }

    @Test
    public void whenGetById_thenShouldReturnOneIdTwo() {
        when(userRepository.getById(2)).thenReturn(MapperUtil.userDto);

        User user  = userService.getUserById(2);

        assertEquals(user, MapperUtil.userExpected);
    }

    @Test
    public void whenCreateUser_thenReturnUser() {
        when(userRepository.save(MapperUtil.userDto)).thenReturn(MapperUtil.userDto);

        User user = userService.createUser(MapperUtil.userExpected);

        assertEquals(user, MapperUtil.userExpected);
    }
}
