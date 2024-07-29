package com.practice.joblisting.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import com.practice.joblisting.constant.Roles;
import com.practice.joblisting.model.RequestValidateErrors;
import com.practice.joblisting.model.Users;
import com.practice.joblisting.model.ValidatorError;
import com.practice.joblisting.model.rest.LoginRequest;
import com.practice.joblisting.model.rest.RegisterRequest;
import com.practice.joblisting.model.rest.RegisterRequestBody;
import com.practice.joblisting.model.rest.RegisterResponseBody;
import com.practice.joblisting.repository.UserRepository;
import com.practice.joblisting.validator.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class UserService {
    //todo: Change later
    final private Integer SALT = 21;

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserValidator userValidator;

    public RegisterResponseBody createUser(RegisterRequest request){
        RegisterResponseBody responseBody = new RegisterResponseBody();
        /**
         * 1. Validate request
         * 2. Check duplicate
         */
        RequestValidateErrors errors = new RequestValidateErrors();
        userValidator.validateRequest(request.getBody(), errors);
        if(!errors.getErrorMessages().isEmpty()){
            responseBody.setRequestValidateErrors(errors);
            return responseBody;
        }
        Optional<Users> user = userRepository.findUserWithEmailOrPassword(request.getBody().getEmail(), request.getBody().getUsername());
        if(user.isPresent()){
            if (user.get().getEmail().equals(request.getBody().getEmail())){
                ValidatorError error = new ValidatorError("email", "email already use");
                errors.getErrorMessages().add(error);

            }
            if (user.get().getUsername().equals(request.getBody().getUsername())){
                ValidatorError error = new ValidatorError("email", "email already use");
                errors.getErrorMessages().add(error);
            }
            responseBody.setRequestValidateErrors(errors);
            return responseBody;
        }

        Users newUser = createNewUser(request.getBody());
        try{
            userRepository.save(newUser);
        }catch (Exception e){
            ValidatorError error = new ValidatorError("", "unable to create new user");
            errors.getErrorMessages().add(error);
            responseBody.setRequestValidateErrors(errors);
        }

        responseBody.setEmail(request.getBody().getEmail());
        responseBody.setUsername(request.getBody().getUsername());

        return responseBody;
    }

    public Boolean logIn(LoginRequest request){
        Optional<Users> user = userRepository.findUserWithEmailOrPassword(request.getBody().getEmail(), request.getBody().getUsername());
        return user.filter(users -> verifyPassword(request.getBody().getPassword(), users.getPassword())).isPresent();
    }

    private Users createNewUser(RegisterRequestBody request){
        String hashedPassword = BCrypt.withDefaults().hashToString(12, request.getPassword().toCharArray());

        Users user = new Users();
        user.setRole(Roles.USER);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(hashedPassword);
        user.setCreatedDate(new Date());
        user.setUpdatedDate(new Date());
        return user;
    }

    private boolean verifyPassword(String userPassword, String password){
        BCrypt.Result result = BCrypt.verifyer().verify(userPassword.toCharArray(), password);
        return result.verified;
    }
}
