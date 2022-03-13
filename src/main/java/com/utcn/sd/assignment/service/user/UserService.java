package com.utcn.sd.assignment.service.user;

import com.utcn.sd.assignment.model.User;
import com.utcn.sd.assignment.model.UserLoginRequest;

import java.util.List;

public interface UserService {
    User getUserById(int id);

    User createUser(User user);

    void deleteUserById(int id);

    List<User> getAllUsers();

    User getUserByEmail(String email);

    User getUserByUsername(String username);

    String login(UserLoginRequest userLoginRequest);

    void banUser(int id);

    void unbanUser(int id);
}
