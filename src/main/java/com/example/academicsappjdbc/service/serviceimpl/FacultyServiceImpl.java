package com.example.academicsappjdbc.service.serviceimpl;

import com.example.academicsappjdbc.dao.FacultyDao;
import com.example.academicsappjdbc.models.Faculty;
import com.example.academicsappjdbc.service.FacultyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacultyServiceImpl implements FacultyService {
    @Autowired
    private FacultyDao facultyDao;

    @Override
    public Faculty findFacultyById(Integer id) {
        Faculty faculty = facultyDao.findById(id);
        if (faculty == null) {
            throw new RuntimeException("Faculty with ID " + id + " not found");
        }
        return faculty;
    }

    @Override
    public List<Faculty> findAllFaculties() {
        return facultyDao.findAll();
    }

    @Override
    public void saveFaculty(Faculty faculty) {
        if (faculty == null ||  faculty.getFacultyName()==null) {
            throw new IllegalArgumentException("Faculty object is null");
        }
        facultyDao.save(faculty);
    }

    @Override
    public void updateFaculty(Faculty faculty) {
        if (faculty == null || faculty.getId() == null || faculty.getFacultyName()==null) {
            throw new IllegalArgumentException("Faculty object or ID is null");
        }
        facultyDao.update(faculty);
    }

    @Override
    public void deleteFaculty(Integer facultyId) {
        Faculty faculty = findFacultyById(facultyId);
        if (faculty != null) {
            facultyDao.delete(facultyId);
        }
    }
}
