package com.semicolon.africa.noteapp.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class EditNoteRequest {
    private String title;
    private String content;

}
