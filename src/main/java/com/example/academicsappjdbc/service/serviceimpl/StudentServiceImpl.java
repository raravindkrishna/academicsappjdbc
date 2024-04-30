package com.example.academicsappjdbc.service.serviceimpl;

import com.example.academicsappjdbc.dao.StudentDao;
import com.example.academicsappjdbc.models.Student;
import com.example.academicsappjdbc.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentDao studentDao;

    @Override
    public Student findStudentById(Integer id) {
        Student student = studentDao.findById(id);
        if (student == null) {
            throw new RuntimeException("Student with ID " + id + " not found");
        }
        return student;
    }

    @Override
    public List<Student> findAllStudents() {
        return studentDao.findAll();
    }

    @Override
    public void saveStudent(Student student) {
        if (student == null || student.getStudentName()==null || student.getRollNo()==null) {
            throw new IllegalArgumentException("Student object is null");
        }
        studentDao.save(student);
    }

    @Override
    public void updateStudent(Student student) {
        if (student == null || student.getId() == null || student.getStudentName()==null || student.getRollNo()==null) {
            throw new IllegalArgumentException("Student object or ID is null");
        }
        studentDao.update(student);
    }

    @Override
    public void deleteStudent(Integer studentId) {
        Student student = findStudentById(studentId);
        if (student != null) {
            studentDao.delete(studentId);
        }
    }
}

