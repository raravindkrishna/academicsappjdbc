package com.example.academicsappjdbc.controller;

import com.example.academicsappjdbc.models.Student;
import com.example.academicsappjdbc.service.serviceimpl.CGSSServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classGroup/{classGroupId}/students")
public class ClassGroupStudentController {

    @Autowired
    private CGSSServiceImpl classGroupStudentService;

    @PostMapping("/{studentId}")
    public ResponseEntity addStudentToClassGroup(
            @PathVariable("classGroupId") Integer classGroupId,
            @PathVariable("studentId") Integer studentId) {
        try {
            classGroupStudentService.addStudentToClassGroup(classGroupId, studentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudentsInClassGroup(
            @PathVariable("classGroupId") Integer classGroupId) {
        try {
            List<Student> students = classGroupStudentService.getAllStudentsInClassGroup(classGroupId);
            return new ResponseEntity<>(students,HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping
    public ResponseEntity removeStudentFromClassGroup(
            @PathVariable("classGroupId") Integer classGroupId,
            @RequestParam("id") List<Integer> ids) {
        try {
            classGroupStudentService.removeStudentsFromClassGroup(classGroupId, ids);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Failed to remove student from class group: " + e.getMessage());
        }
    }

}

