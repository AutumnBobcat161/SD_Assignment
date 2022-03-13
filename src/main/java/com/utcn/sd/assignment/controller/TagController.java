package com.utcn.sd.assignment.controller;

import com.utcn.sd.assignment.model.Tag;
import com.utcn.sd.assignment.service.TagServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/tag")
public class TagController {

    @Autowired
    private TagServiceImpl service;

    @GetMapping("/{id}")
    public ResponseEntity<Tag> findById(@PathVariable(value = "id") int id) {
        return new ResponseEntity<>(service.getTagById(id), HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Tag> createTag(@RequestBody Tag tag) {
        return new ResponseEntity<>(service.createTag(tag), HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Tag>> findAll() {
        return new ResponseEntity<>(service.getAllTags(), HttpStatus.OK);
    }
}
