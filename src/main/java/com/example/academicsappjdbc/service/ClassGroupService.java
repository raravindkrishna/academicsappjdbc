package com.example.academicsappjdbc.service;

import com.example.academicsappjdbc.models.ClassGroup;

import java.util.List;

public interface ClassGroupService {
    ClassGroup findClassGroupById(Integer id);
    List<ClassGroup> findAllClassGroups();
    void saveClassGroup(ClassGroup classGroup);
    void updateClassGroup(ClassGroup classGroup);
    void deleteClassGroup(Integer id);

    void updateFacultyOfClassGroup(Integer classGroupId, Integer facultyId);
}

