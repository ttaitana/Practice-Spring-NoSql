package com.practice.joblisting.repository;

import com.practice.joblisting.model.Users;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<Users, String> {

    @Query("{$or: [{email : ?0}, {username: ?1}]}")
    public Optional<Users> findUserWithEmailOrPassword(String email, String username);

    @Query("{email : ?0}")
    public Optional<Users> findByEmail(String email);

    @Query("{username: ?0}")
    public Optional<Users> findByUsername(String username);
}
