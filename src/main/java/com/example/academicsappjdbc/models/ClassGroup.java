package com.example.academicsappjdbc.models;

import lombok.Data;

@Data
public class ClassGroup {
    private Integer id;
    private String classGroupName;
    private Integer facultyId;
    private Integer courseId;


}
