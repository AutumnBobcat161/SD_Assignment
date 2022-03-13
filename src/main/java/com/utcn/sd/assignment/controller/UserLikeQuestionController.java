package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.model.*;
import com.utcn.sd.assignment.service.question.QuestionServiceImpl;
import com.utcn.sd.assignment.service.user.UserServiceImpl;
import com.utcn.sd.assignment.service.user.like.UserLikeQuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/userLikeQuestion")
public class UserLikeQuestionController {

    @Autowired
    private UserLikeQuestionServiceImpl service;

    @Autowired
    private QuestionServiceImpl questionService;

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/{id}")
    public ResponseEntity<UserLikeQuestion> findById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(service.getUserLikeQuestionById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<UserLikeQuestion> createUserLikeQuestion(@RequestBody UserLikeQuestion userLikeQuestion) {
        return new ResponseEntity<>(service.createUserLikeQuestion(userLikeQuestion), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUserLikeQuestion(@PathVariable(value = "id") int id) {
        service.deleteUserLikeQuestionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserLikeQuestion>> findAll() {
        return new ResponseEntity<>(service.getAllUserLikeQuestion(), HttpStatus.OK);
    }
}
