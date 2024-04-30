package com.example.academicsappjdbc.controller;

import com.example.academicsappjdbc.models.Faculty;
import com.example.academicsappjdbc.service.FacultyService;
import com.example.academicsappjdbc.service.serviceimpl.FacultyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/faculty")
public class FacultyController {
    @Autowired
    private FacultyServiceImpl facultyService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getFacultyById(@PathVariable int id) {
        try {
            Faculty faculty = facultyService.findFacultyById(id);
            if (faculty != null) {
                return new ResponseEntity<>(faculty, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching faculty: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllFaculties() {
        try {
            List<Faculty> faculties = facultyService.findAllFaculties();
            return  new ResponseEntity<>(faculties, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching facultys: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addFaculty(@RequestBody Faculty faculty) {
        try {
            facultyService.saveFaculty(faculty);
            return  new ResponseEntity<>(faculty, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding faculty: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateFaculty(@PathVariable int id, @RequestBody Faculty faculty) {
        try {
            if (faculty != null && faculty.getId() != null && faculty.getId() == id) {
                facultyService.updateFaculty(faculty);
                return new ResponseEntity<>(faculty, HttpStatus.OK);
            } else {
                return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating faculty: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteFaculty(@RequestParam("id") List<Integer> ids) {
        try {
            for (Integer id : ids) {
                facultyService.deleteFaculty(id);
            }
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting faculty: " + e.getMessage());
        }
    }
}

