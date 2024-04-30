package com.example.academicsappjdbc.service.serviceimpl;

import com.example.academicsappjdbc.dao.ClassGroupDao;
import com.example.academicsappjdbc.dao.FacultyDao;
import com.example.academicsappjdbc.models.ClassGroup;

import com.example.academicsappjdbc.models.Faculty;
import com.example.academicsappjdbc.service.ClassGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClassGroupServiceImpl implements ClassGroupService {
    @Autowired
    private ClassGroupDao classGroupDao;

    @Autowired
    private FacultyDao facultyDao;

    @Override
    public ClassGroup findClassGroupById(Integer id) {
        ClassGroup classGroup = classGroupDao.findById(id);
        if (classGroup == null) {
            throw new RuntimeException("ClassGroup with ID " + id + " not found");
        }
        return classGroup;
    }

    @Override
    public List<ClassGroup> findAllClassGroups() {
        return classGroupDao.findAll();
    }

    @Override
    public void saveClassGroup(ClassGroup classGroup) {
        if (classGroup.getClassGroupName() == null || classGroup.getFacultyId()==null || classGroup.getCourseId()==null) {
            throw new IllegalArgumentException("ClassGroup object details are null");
        }
        classGroupDao.save(classGroup);
    }

    @Override
    public void updateClassGroup(ClassGroup classGroup) {
        if (classGroup == null || classGroup.getId() == null  || classGroup.getFacultyId()==null || classGroup.getCourseId()==null) {
            throw new IllegalArgumentException("ClassGroup object or ID is null");
        }
        classGroupDao.update(classGroup);
    }

    @Override
    public void deleteClassGroup(Integer classGroupId) {
        ClassGroup classGroup = findClassGroupById(classGroupId);
        if (classGroup != null) {
            classGroupDao.delete(classGroupId);
        }
    }

    @Override
    public void updateFacultyOfClassGroup(Integer classGroupId, Integer facultyId){
        if (classGroupId == null && facultyId == null) {
            throw new IllegalArgumentException("ClassGroupId and FacultyId must not be null");
        }
      else{
            Faculty newFaculty = facultyDao.findById(facultyId);
            ClassGroup updatedClassGroup = classGroupDao.findById(classGroupId);
        }
      classGroupDao.updateFacultyOfClassGroup(classGroupId, facultyId);
    }
}
