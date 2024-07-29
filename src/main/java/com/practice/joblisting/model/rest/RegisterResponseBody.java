package com.practice.joblisting.model.rest;

import com.practice.joblisting.model.RequestValidateErrors;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RegisterResponseBody {
    private String username;
    private String email;
    private RequestValidateErrors requestValidateErrors;
}
