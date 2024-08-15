package com.semicolon.africa.noteapp.Data.repositories;

import com.semicolon.africa.noteapp.Data.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserRepository extends MongoRepository<User, String> {
    Optional<User> findByEmail(String email);
    User findByEmailIgnoreCase(String email);

}
