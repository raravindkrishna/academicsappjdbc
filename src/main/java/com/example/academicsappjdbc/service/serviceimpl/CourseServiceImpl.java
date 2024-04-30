package com.example.academicsappjdbc.service.serviceimpl;

import com.example.academicsappjdbc.dao.CourseDao;
import com.example.academicsappjdbc.models.Course;
import com.example.academicsappjdbc.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    private CourseDao courseDao;

    @Override
    public Course findCourseById(Integer id) {
        Course course = courseDao.findById(id);
        if (course == null) {
            throw new RuntimeException("Course with ID " + id + " not found");
        }
        return course;
    }

    @Override
    public List<Course> findAllCourses() {
        return courseDao.findAll();
    }

    @Override
    public void saveCourse(Course course) {
        if (course.getCourseName() == null || course.getCourseCode()==null) {
            throw new IllegalArgumentException("Course object details are null");
        }
        courseDao.save(course);
    }

    @Override
    public void updateCourse(Course course) {
        if (course == null || course.getId() == null  || course.getCourseName()==null || course.getCourseCode()==null) {
            throw new IllegalArgumentException("Course object or ID is null");
        }
        courseDao.update(course);
    }

    @Override
    public void deleteCourse(Integer courseId) {
        Course course = findCourseById(courseId);
        if (course != null) {
            courseDao.delete(courseId);
        }
    }
}
