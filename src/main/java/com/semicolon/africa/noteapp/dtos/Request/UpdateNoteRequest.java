package com.semicolon.africa.noteapp.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateNoteRequest {
    private String id;
    private String newTitle;
    private String newContent;
}
