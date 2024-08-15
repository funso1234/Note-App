package com.semicolon.africa.noteapp.Services;

import com.semicolon.africa.noteapp.Data.Model.Note;
import com.semicolon.africa.noteapp.Data.repositories.NoteRepository;
import com.semicolon.africa.noteapp.Exceptions.NoteNotFoundException;
import com.semicolon.africa.noteapp.Services.NoteServices;
import com.semicolon.africa.noteapp.dtos.Request.AddNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateNoteRequest;
import com.semicolon.africa.noteapp.dtos.Response.AddNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateNoteResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class NoteServicesImpl implements NoteServices{
    @Autowired
    NoteRepository noteRepository;
    @Override
    public AddNoteResponse addNote(AddNoteRequest addNoteRequest) {
        Note note = new Note();
        note.setTitle(addNoteRequest.getTitle());
        note.setContent(addNoteRequest.getContent());
        noteRepository.save(note);
        AddNoteResponse addNoteResponse = new AddNoteResponse();
        addNoteResponse.setMessage("Note succesfully added");
        return addNoteResponse;
    }

    @Override
    public UpdateNoteResponse updateNote(UpdateNoteRequest updateNoteRequest){
        Note note = noteRepository.findById(updateNoteRequest.getId()).
                orElseThrow(()-> new NoteNotFoundException("Note not found"));
        note.setTitle(updateNoteRequest.getNewTitle());
        note.setContent(updateNoteRequest.getNewContent());
        noteRepository.save(note);
        UpdateNoteResponse updateNoteResponse = new UpdateNoteResponse();
        updateNoteResponse.setMessage("Note successfully updated");
        return updateNoteResponse;
    }


//    @Override
//    public EditNoteResponse editNote(EditNoteRequest editNoteRequest){
//        Note note = new Note();
//        note.setTitle(editNoteRequest.getTitle());
//        note.setContent(editNoteRequest.getContent());
//        noteRepository.save(note);
//        EditNoteResponse editNoteResponse = new EditNoteResponse();
//        editNoteResponse.setMessage("Note successfully updated");
//        return editNoteResponse;
//    }

    @Override
    public DeleteNoteResponse deleteNote(DeleteNoteRequest deleteNoteRequest){
        List<Note> note = noteRepository.findByEmail(deleteNoteRequest.getEmail());
        DeleteUserResponse deleteUserResponse = new DeleteUserResponse();
        return new DeleteNoteResponse("Deleted note successfully");
    }

    @Override
    public List<Note> getAllNotes() {
        return List.of();
    }
}
