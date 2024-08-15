package com.semicolon.africa.noteapp.Services;

import com.semicolon.africa.noteapp.Data.Model.Note;
import com.semicolon.africa.noteapp.dtos.Request.AddNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.EditNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateNoteRequest;
import com.semicolon.africa.noteapp.dtos.Response.AddNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.EditNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateNoteResponse;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface NoteServices{
    AddNoteResponse addNote(AddNoteRequest addNoteRequest);
    UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest);
//    EditNoteResponse editNote(EditNoteRequest editNoteRequest);
    DeleteNoteResponse deleteNote(DeleteNoteRequest deleteNoteRequest);
    List<Note> getAllNotes();
}
