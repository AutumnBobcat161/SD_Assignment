package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.model.*;
import com.utcn.sd.assignment.service.question.QuestionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/question")
public class QuestionController {

    @Autowired
    private QuestionServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<QuestionResponse> findById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(service.getQuestionById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Question> createQuestion(@RequestBody QuestionRequest question) {
        return new ResponseEntity<>(service.createQuestion(question), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteQuestion(@PathVariable(value = "id") int id) {
        service.deleteQuestionById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<QuestionResponse>> findAll() {
        return new ResponseEntity<>(service.getAllQuestions(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Question> updateQuestion(@RequestBody QuestionRequest question) {
        return new ResponseEntity<>(service.createQuestion(question), HttpStatus.CREATED);
    }

    @PostMapping("/search")
    public ResponseEntity<List<QuestionResponse>> search(@RequestBody SearchRequest request) {
        return new ResponseEntity<>(service.searchQuestions(request), HttpStatus.OK);
    }

}
