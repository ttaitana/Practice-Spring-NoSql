package com.practice.joblisting.model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestValidateErrors {
    private List<ValidatorError> errorMessages = new ArrayList<>();
}
