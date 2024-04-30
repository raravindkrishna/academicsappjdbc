package com.example.academicsappjdbc.service.serviceimpl;

import com.example.academicsappjdbc.dao.ClassGroupStudentDao;
import com.example.academicsappjdbc.models.ClassGroupStudent;
import com.example.academicsappjdbc.models.Student;
import com.example.academicsappjdbc.service.ClassGroupStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class CGSSServiceImpl implements ClassGroupStudentService {
    @Autowired
    private ClassGroupStudentDao classGroupStudentDao;

    @Override
    public void addStudentToClassGroup(Integer classGroupId, Integer studentId) {
        if (classGroupId ==null || studentId==null) {
            throw new IllegalArgumentException("Invalid class group ID or student ID.");
        }
        classGroupStudentDao.addStudentToClassGroup(classGroupId, studentId);
    }

    @Override
    public List<Student> getAllStudentsInClassGroup(Integer classGroupId) {
        if (classGroupId == null) {
            throw new IllegalArgumentException("Invalid class group ID.");
        }
        return classGroupStudentDao.getAllStudentsInClassGroup(classGroupId);
    }
    @Override
    public void removeStudentsFromClassGroup(Integer classGroupId, List<Integer> ids) {
        if (classGroupId == null) {
            throw new IllegalArgumentException("classGroup id must not be null");
        }
       for(Integer id: ids) {
           classGroupStudentDao.removeStudentsFromClassGroup(classGroupId, id);
       }
    }
}
