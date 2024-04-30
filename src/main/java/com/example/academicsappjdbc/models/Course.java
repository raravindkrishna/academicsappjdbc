package com.example.academicsappjdbc.models;

import lombok.Data;

@Data
public class Course {
    private Integer id;
    private String courseName;
    private String description;
    private String courseCode;

}
