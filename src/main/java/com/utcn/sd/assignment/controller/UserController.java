package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.model.User;
import com.utcn.sd.assignment.model.UserLoginRequest;
import com.utcn.sd.assignment.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User User) {
        User.setBanned(false);
        return new ResponseEntity<>(service.createUser(User), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable(value = "id") int id) {
        service.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(service.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/login")
    public ResponseEntity<String> userLogin(@RequestBody UserLoginRequest userLoginRequest) {
        if (service.login(userLoginRequest).contains("success")) {
            return new ResponseEntity<>(service.login(userLoginRequest), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(service.login(userLoginRequest), HttpStatus.BAD_REQUEST);
        }
    }
}
