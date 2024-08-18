package com.semicolon.africa.noteapp.Data.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Document("sammy")
public class Note {
    @Id
    private String id;
    private String title;
    private String content;
    private String email;
    private LocalDateTime createdAt = LocalDateTime.now();
    private LocalDateTime updatedAt;


}
