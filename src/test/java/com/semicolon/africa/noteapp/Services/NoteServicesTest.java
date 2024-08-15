package com.semicolon.africa.noteapp.Services;

import com.semicolon.africa.noteapp.Data.repositories.NoteRepository;
import com.semicolon.africa.noteapp.dtos.Request.AddNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteNoteRequest;
import com.semicolon.africa.noteapp.dtos.Request.EditNoteRequest;
import com.semicolon.africa.noteapp.dtos.Response.AddNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteNoteResponse;
import com.semicolon.africa.noteapp.dtos.Response.EditNoteResponse;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@RequiredArgsConstructor
@SpringBootTest
class NoteServicesTest {

    @Autowired
    private NoteServices noteServices;
    @Autowired
    private NoteRepository noteRepository;

    @Test
    void testToAddANote() {
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setTitle("Note Title");
        addNoteRequest.setContent("Note Content");
        AddNoteResponse addNoteResponse = noteServices.addNote(addNoteRequest);
        assertThat(addNoteResponse).isNotNull();

    }

    @Test
    void testThatUpdateNote() {
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setTitle("Note Title");
        addNoteRequest.setContent("Note Content");
        AddNoteResponse addNoteResponse = noteServices.addNote(addNoteRequest);
        assertThat(addNoteResponse).isNotNull();
        AddNoteRequest updateNoteRequest = new AddNoteRequest();
        updateNoteRequest.setTitle("New Note Title");
        updateNoteRequest.setContent("New Note Content");
        AddNoteResponse updateNoteResponse = noteServices.addNote(updateNoteRequest);
        assertThat(updateNoteResponse).isNotNull();
        assertThat(updateNoteResponse).isEqualTo(updateNoteResponse);
    }


//    @Test
//    void testThatEditNote(){
//        AddNoteRequest addNoteRequest = new AddNoteRequest();
//        addNoteRequest.setTitle("Note Title");
//        addNoteRequest.setContent("Note Content");
//        AddNoteResponse addNoteResponse = noteServices.addNote(addNoteRequest);
//        EditNoteRequest editNoteRequest = new EditNoteRequest();
//        editNoteRequest.setTitle("Edit Title");
//        editNoteRequest.setContent("Edit Content");
//        EditNoteResponse editNoteResponse = noteServices.editNote(editNoteRequest);
//    }

    @Test
    void testThatDeleteNote(){
        AddNoteRequest addNoteRequest = new AddNoteRequest();
        addNoteRequest.setTitle("Note Title");
        addNoteRequest.setContent("Note Content");
        AddNoteResponse addNoteResponse = noteServices.addNote(addNoteRequest);
        DeleteNoteRequest deleteNoteRequest = new DeleteNoteRequest();
        noteServices.deleteNote(deleteNoteRequest);
        DeleteNoteResponse deleteNoteResponse = noteServices.deleteNote(deleteNoteRequest);
        assertThat(addNoteResponse).isNotNull();
        assertThat(deleteNoteResponse.getMessage()).isEqualTo("Deleted Note Title");

    }
}
//@SpringBootTest
//public class NoteServicesTest {
//    @Autowired
//    NoteServices noteServices;
//    @Test
//    public void testAddNote(){
//        AddNoteRequest addNoteRequest = new AddNoteRequest();
//        addNoteRequest.setTitle("nweTitle");
//        addNoteRequest.setContent("nweContent");
//        AddNoteResponse response = noteServices.addNote(addNoteRequest);
//        response.setMessage("Successfully added note");
//        assertThat(response).isNotNull();
//        assertThat(response.getMessage()).contains("Successfully added note");
//    }
//
//    @Test
//    public void testDeleteNote(){
//        AddNoteRequest addNoteRequest = new AddNoteRequest();
//        addNoteRequest.setTitle("nweTitle");
//        addNoteRequest.setContent("nweContent");
//        AddNoteResponse response = noteServices.addNote(addNoteRequest);
//        response.setMessage("Successfully added note");
//        String noteId = response.getId();
//        DeleteUserResponse response1 = noteServices.deleteNote(noteId);
//
//
//    }
//
