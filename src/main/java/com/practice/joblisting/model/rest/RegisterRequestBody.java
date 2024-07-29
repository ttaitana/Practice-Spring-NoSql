package com.practice.joblisting.model.rest;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterRequestBody {
    private String username;
    private String email;
    private String password;
    private String role;
}
