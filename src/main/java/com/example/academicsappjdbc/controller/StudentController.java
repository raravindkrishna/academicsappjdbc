package com.example.academicsappjdbc.controller;

import com.example.academicsappjdbc.models.Student;
import com.example.academicsappjdbc.service.StudentService;
import com.example.academicsappjdbc.service.serviceimpl.StudentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student")
public class StudentController {
    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getStudentById(@PathVariable int id) {
        try {
            Student student = studentService.findStudentById(id);
            if (student != null) {
                return new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching student: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllStudents() {
        try {
            List<Student> students = studentService.findAllStudents();
            return new ResponseEntity<>(students, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching students: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addStudent(@RequestBody Student student) {
        try {
            studentService.saveStudent(student);
            return new ResponseEntity<>(student, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding student: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateStudent(@PathVariable int id, @RequestBody Student student) {
        try {
            if (student != null && student.getId() != null && student.getId() == id) {
                studentService.updateStudent(student);
                return  new ResponseEntity<>(student, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating student: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteStudent(@RequestParam("id") List<Integer> ids) {
        try {
            for (Integer id : ids) {
                studentService.deleteStudent(id);
            }
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting student: " + e.getMessage());
        }
    }
}
