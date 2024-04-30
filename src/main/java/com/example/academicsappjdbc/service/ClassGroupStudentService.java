package com.example.academicsappjdbc.service;

import com.example.academicsappjdbc.models.ClassGroupStudent;
import com.example.academicsappjdbc.models.Student;

import java.util.List;

public interface ClassGroupStudentService {

    List<Student> getAllStudentsInClassGroup(Integer classGroupId);

    void addStudentToClassGroup(Integer classGroupId, Integer studentId);

    void removeStudentsFromClassGroup(Integer classGroupId, List<Integer> ids);
}
