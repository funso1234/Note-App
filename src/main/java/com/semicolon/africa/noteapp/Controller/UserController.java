package com.semicolon.africa.noteapp.Controller;

import com.semicolon.africa.noteapp.Data.repositories.UserRepository;
import com.semicolon.africa.noteapp.Services.UserServices;
import com.semicolon.africa.noteapp.dtos.Request.CreateUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.LoginRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateUserRequest;
import com.semicolon.africa.noteapp.dtos.Response.CreateUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.LoginResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateUserResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/user")
@RequiredArgsConstructor
public class UserController {
    private final UserServices userServices;
    @PostMapping("/create-user")
    public ResponseEntity<?> addUser(@RequestBody CreateUserRequest createUserRequest) {
        try {
            CreateUserResponse createUserResponse = userServices.addUser(createUserRequest);
            return ResponseEntity.ok(createUserResponse);
        }
        catch (Exception exception) {
            return ResponseEntity.badRequest().body(exception.getMessage());
        }
    }
    @PostMapping("/login-user")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        try {
            LoginResponse loginResponse = userServices.login(loginRequest);
            return new ResponseEntity<>(loginResponse, HttpStatus.CREATED);
        }
        catch (Exception exception) {
            return new  ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @DeleteMapping("delete-user")
    public ResponseEntity<?> deleteUser(@RequestBody DeleteUserRequest deleteUserRequest) {
        try {
            DeleteUserResponse deleteUserResponse = userServices.deleteUser(deleteUserRequest);
            return new ResponseEntity<>(deleteUserResponse, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
    @PostMapping
    public ResponseEntity<?> updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        try {
            UpdateUserResponse updateUserResponse = userServices.updateUser(updateUserRequest);
            return new ResponseEntity<>(updateUserResponse, HttpStatus.OK);
        }
        catch (Exception exception) {
            return new ResponseEntity<>(exception.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
