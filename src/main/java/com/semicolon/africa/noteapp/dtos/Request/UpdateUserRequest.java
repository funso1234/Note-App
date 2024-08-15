package com.semicolon.africa.noteapp.dtos.Request;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UpdateUserRequest {
    private String newId;
    private String newName;
    private String newPassword;
    private String newEmail;
}
