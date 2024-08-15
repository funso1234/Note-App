package com.semicolon.africa.noteapp.Data.Model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Document
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private String password;
    @DBRef
    private List<Note> notes = new ArrayList<>();
}
