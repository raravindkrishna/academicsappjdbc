package com.example.academicsappjdbc.dao;

import com.example.academicsappjdbc.models.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Course findById(int courseId) {
        String sql = "SELECT * FROM Course WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{courseId}, new CourseRowMapper());
    }


    public List<Course> findAll() {
        String sql = "SELECT * FROM Course";
        return jdbcTemplate.query(sql, new CourseRowMapper());
    }


    public void save(Course course) {
        String sql = "INSERT INTO Course (course_name, description, course_code) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, course.getCourseName(), course.getDescription(), course.getCourseCode());
    }


    public void update(Course course) {
        String sql = "UPDATE Course SET course_name = ?, description = ?, course_code = ? WHERE id = ?";
        jdbcTemplate.update(sql, course.getCourseName(), course.getDescription(), course.getCourseCode(), course.getId());
    }


    public void delete(int courseId) {
        String sql = "DELETE FROM Course WHERE id = ?";
        jdbcTemplate.update(sql, courseId);
    }
}
