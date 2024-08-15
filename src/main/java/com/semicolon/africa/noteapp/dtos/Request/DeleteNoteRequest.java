package com.semicolon.africa.noteapp.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class DeleteNoteRequest {
    private String email;
    private String NoteId;
}
