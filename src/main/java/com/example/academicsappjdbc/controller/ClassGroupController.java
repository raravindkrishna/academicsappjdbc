package com.example.academicsappjdbc.controller;

import com.example.academicsappjdbc.models.ClassGroup;
import com.example.academicsappjdbc.service.ClassGroupService;
import com.example.academicsappjdbc.service.serviceimpl.ClassGroupServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/classGroup")
public class ClassGroupController {
    @Autowired
    private ClassGroupServiceImpl classGroupService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getClassGroupById(@PathVariable int id) {
        try {
            ClassGroup classGroup = classGroupService.findClassGroupById(id);
            if (classGroup != null) {
                return new ResponseEntity<>(classGroup, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching classGroup: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllClassGroups() {
        try {
            List<ClassGroup> classGroups = classGroupService.findAllClassGroups();
            return new ResponseEntity<>(classGroups, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching classGroups: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addClassGroup(@RequestBody ClassGroup classGroup) {
        try {
            classGroupService.saveClassGroup(classGroup);
            return new ResponseEntity<>(classGroup, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding classGroup: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateClassGroup(@PathVariable int id, @RequestBody ClassGroup classGroup) {
        try {
            if (classGroup != null && classGroup.getId() != null && classGroup.getId() == id) {
                classGroupService.updateClassGroup(classGroup);
                return  new ResponseEntity<>(classGroup, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating classGroup: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteClassGroup(@RequestParam("id") List<Integer> ids) {
        try {
            for (Integer id : ids) {
                classGroupService.deleteClassGroup(id);
            }
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting classGroup: " + e.getMessage());
        }
    }
    @PutMapping("/{classGroupId}/faculty/{facultyId}")
    public ResponseEntity<?> updateFacultyOfClassGroup(@PathVariable Integer classGroupId, @PathVariable Integer facultyId) {
        try {
            classGroupService.updateFacultyOfClassGroup(classGroupId, facultyId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating Faculty: " + e.getMessage());
        }
    }
}

