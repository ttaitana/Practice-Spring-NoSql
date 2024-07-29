package com.practice.joblisting.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "users")
public class Users {
    private String username;
    private String email;
    private String password;
    private String role;
    private Date createdDate;
    private Date updatedDate;
}
