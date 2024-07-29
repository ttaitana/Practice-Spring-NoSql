package com.practice.joblisting.validator;

import com.practice.joblisting.model.RequestValidateErrors;
import com.practice.joblisting.model.ValidatorError;
import org.springframework.stereotype.Component;

@Component
public abstract class Validator<T> {
    public void validateRequest(T request, RequestValidateErrors errors){
        validateMandatory(request, errors);
        validateConditional(request, errors);
    }

    protected void validateMandatory(T request, RequestValidateErrors errors) {
    }

    protected void validateConditional(T request, RequestValidateErrors errors) {
    }

    protected ValidatorError createError(String fieldName, String condition){
        return new ValidatorError(fieldName, condition);
    }
}
