package com.semicolon.africa.noteapp.Services;

import com.semicolon.africa.noteapp.Data.Model.User;
import com.semicolon.africa.noteapp.dtos.Request.CreateUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.LoginRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateUserRequest;
import com.semicolon.africa.noteapp.dtos.Response.CreateUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.LoginResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateUserResponse;
import org.springframework.stereotype.Service;


public interface UserServices {


    CreateUserResponse addUser(CreateUserRequest createUserRequest);
    DeleteUserResponse deleteUser(DeleteUserRequest deleteUserRequest);
    User getUserById(String id);
    UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest);
    LoginResponse login(LoginRequest loginRequest);
    User findUserByEmail(String email);

}
