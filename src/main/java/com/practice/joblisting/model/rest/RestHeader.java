package com.practice.joblisting.model.rest;

import lombok.Data;

import java.util.Date;


@Data
public class RestHeader {
    private String appId;
    private Date reDt;
    private String statusCode;
    private String service;
}
