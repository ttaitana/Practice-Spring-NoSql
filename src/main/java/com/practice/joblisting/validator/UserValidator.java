package com.practice.joblisting.validator;

import com.practice.joblisting.model.RequestValidateErrors;
import com.practice.joblisting.model.ValidatorError;
import com.practice.joblisting.model.rest.RegisterRequestBody;
import org.springframework.stereotype.Component;

import static com.practice.joblisting.constant.RegexPattern.VALID_EMAIL_ADDRESS_REGEX;

@Component
public class UserValidator extends Validator<RegisterRequestBody> {

    private final String MANDATORY = "Empty or Incorrect format";

    @Override
    public void validateMandatory(RegisterRequestBody request, RequestValidateErrors errors) {
        if(request.getEmail() == null || !VALID_EMAIL_ADDRESS_REGEX.matcher(request.getEmail()).matches()){
            errors.getErrorMessages().add(this.createError("email", MANDATORY));
        }
        if(request.getUsername() == null ){
            errors.getErrorMessages().add(this.createError("username", MANDATORY));
        }
        if(request.getPassword() == null ){
            errors.getErrorMessages().add(this.createError("password", MANDATORY));
        }
    }

    @Override
    public void validateConditional(RegisterRequestBody request, RequestValidateErrors errors) {

    }
}
