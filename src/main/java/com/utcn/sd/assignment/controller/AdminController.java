package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.service.user.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/ban/{id}")
    public ResponseEntity<Void> banUser(@PathVariable(value = "id") int id) {
        userService.banUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/unban/{id}")
    public ResponseEntity<Void> unbanUser(@PathVariable(value = "id") int id) {
        userService.unbanUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
