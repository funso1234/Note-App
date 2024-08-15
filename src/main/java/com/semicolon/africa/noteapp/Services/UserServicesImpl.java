package com.semicolon.africa.noteapp.Services;

import com.semicolon.africa.noteapp.Data.Model.User;
import com.semicolon.africa.noteapp.Data.repositories.UserRepository;
import com.semicolon.africa.noteapp.Exceptions.UserNotFoundException;
import com.semicolon.africa.noteapp.dtos.Request.CreateUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.DeleteUserRequest;
import com.semicolon.africa.noteapp.dtos.Request.LoginRequest;
import com.semicolon.africa.noteapp.dtos.Request.UpdateUserRequest;
import com.semicolon.africa.noteapp.dtos.Response.CreateUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.DeleteUserResponse;
import com.semicolon.africa.noteapp.dtos.Response.LoginResponse;
import com.semicolon.africa.noteapp.dtos.Response.UpdateUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServicesImpl implements UserServices{
    @Autowired
    private UserRepository userRepository;

    @Override
    public CreateUserResponse addUser(CreateUserRequest createUserRequest) {
        if(userRepository.findByEmailIgnoreCase(createUserRequest.getEmail())!= null)
            throw new RuntimeException("Email already exists");
        User user = new User();
        user.setName(createUserRequest.getName());
        user.setEmail(createUserRequest.getEmail());
        user.setPassword(createUserRequest.getPassword());
        user = userRepository.save(user);

        CreateUserResponse createUserResponse = new CreateUserResponse();
        createUserResponse.setMessage("User added successfully");
        createUserResponse.setId(user.getId());
        return createUserResponse;
    }
    @Override
    public DeleteUserResponse deleteUser(DeleteUserRequest deleteUserRequest){
        User foundUser = getUserById(deleteUserRequest.getUserId());
        userRepository.delete(foundUser);
    DeleteUserResponse deleteUserResponse = new DeleteUserResponse();
    deleteUserResponse.setMessage("User deleted Successfully");
    return deleteUserResponse;
    }
@Override
public User getUserById(String id) {
    return userRepository.findById(id).
                orElseThrow(()-> new RuntimeException("User not found"));
    }

    @Override
    public UpdateUserResponse updateUser(UpdateUserRequest updateUserRequest){
        User user = userRepository.findByEmail(updateUserRequest.getNewEmail()).
                orElseThrow(()-> new UserNotFoundException("User not found"));
        user.setName(updateUserRequest.getNewName());
        user.setPassword(updateUserRequest.getNewPassword());
        userRepository.save(user);
        UpdateUserResponse updateUserResponse = new UpdateUserResponse();
        updateUserResponse.setMessage("User updated Successfully");
        return updateUserResponse;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest){
        User user = userRepository.findByEmail(loginRequest.getEmail()).
                orElseThrow(()-> new UserNotFoundException("login not found"));
        loginRequest.setEmail(loginRequest.getEmail());
        loginRequest.setPassword(loginRequest.getPassword());
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setMessage("Login Successfully");
        return loginResponse;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmailIgnoreCase(email);
    }
}
