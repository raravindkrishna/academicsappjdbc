package com.example.academicsappjdbc.service;

import com.example.academicsappjdbc.models.Student;

import java.util.List;

public interface StudentService {
    Student findStudentById(Integer id);
    List<Student> findAllStudents();
    void saveStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Integer studentId);
}
