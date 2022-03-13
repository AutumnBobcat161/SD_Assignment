package com.utcn.sd.assignment.controller;


import com.utcn.sd.assignment.model.UserLikeAnswer;
import com.utcn.sd.assignment.service.AnswerServiceImpl;
import com.utcn.sd.assignment.service.user.UserServiceImpl;
import com.utcn.sd.assignment.service.user.like.UserLikeAnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userLikeAnswer")
public class UserLikeAnswerController {

    @Autowired
    private UserLikeAnswerServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<UserLikeAnswer> findById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(service.getUserLikeAnswerById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserLikeAnswer> createUserLikeAnswer(@RequestBody UserLikeAnswer userLikeAnswer) {
        return new ResponseEntity<>(service.createUserLikeAnswer(userLikeAnswer), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserLikeAnswer(@PathVariable(value = "id") int id) {
        service.deleteUserLikeAnswerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserLikeAnswer>> findAll() {
        return new ResponseEntity<>(service.getAllUserLikeAnswer(), HttpStatus.OK);
    }
}
