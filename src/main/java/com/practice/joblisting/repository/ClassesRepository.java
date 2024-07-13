package com.practice.joblisting.repository;

import com.practice.joblisting.model.Classes;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends MongoRepository<Classes, String> {
}
