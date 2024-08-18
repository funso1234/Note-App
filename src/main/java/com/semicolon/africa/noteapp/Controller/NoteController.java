package com.semicolon.africa.noteapp.Controller;

import com.semicolon.africa.noteapp.Services.NoteServices;
import com.semicolon.africa.noteapp.dtos.Request.AddNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateNoteRequest;
import com.semicolon.africa.noteapp.dtos.Response.AddNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/note")
@RequiredArgsConstructor
public class NoteController {
    private NoteServices noteServices;

    @PostMapping("/add-note")
    public ResponseEntity<?> addNote(@RequestBody AddNoteRequest addNoteRequest){
        try {
            AddNoteResponse addNoteResponse = noteServices.addNote(addNoteRequest);
            return new ResponseEntity<>(addNoteResponse, HttpStatus.CREATED);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("/delete-note")
    public ResponseEntity<?> deleteNote(@RequestBody DeleteNoteRequest deleteNoteRequest){
        try {
            DeleteNoteResponse deleteNoteResponse = noteServices.deleteNote(deleteNoteRequest);
            return new ResponseEntity<>(deleteNoteResponse, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("update-note")
    public ResponseEntity<?> updateNote(@RequestBody UpdateNoteRequest updateNoteRequest){
        try {
            UpdateNoteResponse updateUserResponse = noteServices.updateNote(updateNoteRequest);
            return new ResponseEntity<>(updateUserResponse, HttpStatus.OK);
        }
        catch (Exception exception){
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
