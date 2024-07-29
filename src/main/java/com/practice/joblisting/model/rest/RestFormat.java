package com.practice.joblisting.model.rest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RestFormat<T> {
    private RestHeader header;
    private T body;
}
