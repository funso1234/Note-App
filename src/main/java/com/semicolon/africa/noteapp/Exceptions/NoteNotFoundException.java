package com.semicolon.africa.noteapp.Exceptions;

public class NoteNotFoundException extends RuntimeException{
    public NoteNotFoundException(String message){
        super(message);
    }
}
