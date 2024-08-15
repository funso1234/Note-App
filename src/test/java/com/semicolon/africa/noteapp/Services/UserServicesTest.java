package com.semicolon.africa.noteapp.Services;

import com.semicolon.africa.noteapp.Data.Model.User;
import com.semicolon.africa.noteapp.Data.repositories.UserRepository;
import com.semicolon.africa.noteapp.dtos.Request.CreateUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateUserRequest;
import com.semicolon.africa.noteapp.dtos.Response.CreateUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateUserResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class UserServicesTest {
    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Autowired
    private UserServices userServices;

    @Autowired
    private UserRepository userRepository;

    @Test
    void testThatCreateAUser(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("oba");
        createUserRequest.setPassword("6754");
        createUserRequest.setEmail("sam@email.com");
        CreateUserResponse createUserResponse = userServices.addUser(createUserRequest);
        assertThat(createUserResponse).isNotNull();
    }
    @Test
    void testThatDeleteAUser(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("New User");
        createUserRequest.setPassword("password");
        createUserRequest.setEmail("funso@email.com");
        CreateUserResponse createUserResponse = userServices.addUser(createUserRequest);
        assertThat(createUserResponse).isNotNull();
        //assertThat(createUserResponse.getMessage()).isEqualTo("User added successfully");

        User foundUser = userServices.getUserById(createUserResponse.getId());
        DeleteUserRequest deleteUserRequest = new DeleteUserRequest();
        deleteUserRequest.setUserId(foundUser.getId());
        DeleteUserResponse deleteUserResponse = userServices.deleteUser(deleteUserRequest);
        assertThat(deleteUserResponse.getMessage()).isEqualTo("User deleted Successfully");

    }

    @Test
    void testThatUpdateAUser(){
        CreateUserRequest createUserRequest = new CreateUserRequest();
        createUserRequest.setName("oba");
        createUserRequest.setPassword("6754");
        createUserRequest.setEmail("yin@email.com");
        CreateUserResponse createUserResponse = userServices.addUser(createUserRequest);
        assertThat(createUserResponse).isNotNull();
        User foundUser = userServices.getUserById(createUserResponse.getId());
        UpdateUserRequest updateUserRequest = new UpdateUserRequest();
        updateUserRequest.setNewName("oba");
        updateUserRequest.setNewPassword("6754");
        updateUserRequest.setNewEmail("yin@email.com");
        userServices.updateUser(updateUserRequest);
        UpdateUserResponse updateUserResponse = userServices.updateUser(updateUserRequest);
        assertThat(updateUserResponse.getMessage()).isEqualTo("User updated Successfully");
    }

}