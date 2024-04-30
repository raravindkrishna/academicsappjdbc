package com.example.academicsappjdbc.service;

import com.example.academicsappjdbc.models.Faculty;

import java.util.List;

public interface FacultyService {
    Faculty findFacultyById(Integer id);
    List<Faculty> findAllFaculties();
    void saveFaculty(Faculty faculty);
    void updateFaculty(Faculty faculty);
    void deleteFaculty(Integer facultyId);
}
