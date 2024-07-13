package com.practice.joblisting.service;

import com.practice.joblisting.model.Classes;
import com.practice.joblisting.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassesService {
    @Autowired
    private ClassesRepository classesRepository;

    public List<Classes> getAllClass(){
        return classesRepository.findAll();
    }
}
