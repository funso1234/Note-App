package com.semicolon.africa.noteapp.Data.repositories;

import com.semicolon.africa.noteapp.Data.Model.Note;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoteRepository extends MongoRepository<Note, String> {
    List<Note> findByEmail(String email);
}
