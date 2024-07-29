package com.practice.joblisting.controller;

import com.practice.joblisting.model.rest.*;
import com.practice.joblisting.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public boolean login(@RequestBody LoginRequest request){
        return userService.logIn(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest request){
        RegisterResponseBody body = userService.createUser(request);

        RegisterResponse response = new RegisterResponse();
        RestHeader header = new RestHeader();
        header.setAppId("001");
        header.setService("NoSqlTest");
        header.setReDt(new Date());
        header.setStatusCode(body.getRequestValidateErrors().getErrorMessages().isEmpty() ? "00" : "20");

        response.setHeader(header);
        response.setBody(body);
        return response;
    }
}
