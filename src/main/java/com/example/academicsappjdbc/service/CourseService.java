package com.example.academicsappjdbc.service;

import com.example.academicsappjdbc.models.Course;

import java.util.List;

public interface CourseService {
    Course findCourseById(Integer id);
    List<Course> findAllCourses();
    void saveCourse(Course course);
    void updateCourse(Course course);
    void deleteCourse(Integer courseId);
}
