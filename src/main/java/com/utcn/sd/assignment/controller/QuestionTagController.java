package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.model.QuestionTag;
import com.utcn.sd.assignment.service.question.QuestionTagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/question/tag")
public class QuestionTagController {

    @Autowired
    private QuestionTagServiceImpl service;

    @GetMapping("/all")
    public ResponseEntity<List<QuestionTag>> findAll() {
        return new ResponseEntity<>(service.getAllQuestionTags(), HttpStatus.OK);
    }
}
