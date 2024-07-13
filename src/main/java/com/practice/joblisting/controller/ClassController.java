package com.practice.joblisting.controller;

import com.practice.joblisting.model.Classes;
import com.practice.joblisting.service.ClassesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/job")
public class ClassController {
    @Autowired
    private ClassesService classesService;

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public List<Classes> getAllClasses(){
        return classesService.getAllClass();
    }
}
