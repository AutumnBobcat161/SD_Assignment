package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.model.Answer;
import com.utcn.sd.assignment.model.AnswerResponse;
import com.utcn.sd.assignment.model.SortByVotes;
import com.utcn.sd.assignment.service.AnswerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/answer")
public class AnswerController {
    @Autowired
    private AnswerServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<AnswerResponse> findById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(service.getAnswerById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Answer> createAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<>(service.createAnswer(answer), HttpStatus.CREATED);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Void> deleteAnswer(@PathVariable(value = "id") int id) {
        service.deleteAnswerById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AnswerResponse>> findAll() {
        return new ResponseEntity<>(service.getAllAnswers(), HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Answer> updateAnswer(@RequestBody Answer answer) {
        return new ResponseEntity<>(service.createAnswer(answer), HttpStatus.CREATED);
    }

}
