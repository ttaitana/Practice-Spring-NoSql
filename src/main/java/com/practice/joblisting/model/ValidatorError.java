package com.practice.joblisting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ValidatorError {
    private String fieldName;
    private String condition;
}
