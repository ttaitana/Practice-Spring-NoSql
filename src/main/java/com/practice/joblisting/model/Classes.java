package com.practice.joblisting.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Classes {
    private String id;
    private String name;
    private String image;
    private String description;
    private Stats stats;
}
