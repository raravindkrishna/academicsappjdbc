package com.example.academicsappjdbc.controller;

import com.example.academicsappjdbc.models.Course;
import com.example.academicsappjdbc.service.CourseService;
import com.example.academicsappjdbc.service.serviceimpl.CourseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    @Autowired
    private CourseServiceImpl courseService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getCourseById(@PathVariable int id) {
        try {
            Course course = courseService.findCourseById(id);
            if (course != null) {
                return new ResponseEntity<>(course, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching course: " + e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllCourses() {
        try {
            List<Course> courses = courseService.findAllCourses();
            return new ResponseEntity<>(courses, HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while fetching courses: " + e.getMessage());
        }
    }

    @PostMapping
    public ResponseEntity<?> addCourse(@RequestBody Course course) {
        try {
            courseService.saveCourse(course);
            return new ResponseEntity<>(course, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while adding course: " + e.getMessage());
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateCourse(@PathVariable int id, @RequestBody Course course) {
        try {
            if (course != null && course.getId() != null && course.getId() == id) {
                courseService.updateCourse(course);
                return  new ResponseEntity<>(course, HttpStatus.OK);
            } else {
                 return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while updating course: " + e.getMessage());
        }
    }

    @DeleteMapping
    public ResponseEntity<?> deleteCourse(@RequestParam("id") List<Integer> ids) {
        try {
            for (Integer id : ids) {
                courseService.deleteCourse(id);
            }
            return new ResponseEntity<>( HttpStatus.OK);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error occurred while deleting course: " + e.getMessage());
        }
    }
}
