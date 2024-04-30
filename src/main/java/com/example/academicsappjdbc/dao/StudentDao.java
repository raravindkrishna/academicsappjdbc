package com.example.academicsappjdbc.dao;

import com.example.academicsappjdbc.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Student findById(int studentId) {
        String sql = "SELECT * FROM Student WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{studentId}, new StudentRowMapper());
    }


    public List<Student> findAll() {
        String sql = "SELECT * FROM Student";
        return jdbcTemplate.query(sql, new StudentRowMapper());
    }


    public void save(Student student) {
        String sql = "INSERT INTO Student (student_name,roll_no) VALUES (?,?)";
        jdbcTemplate.update(sql, student.getStudentName(), student.getRollNo());
    }


    public void update(Student student) {
        String sql = "UPDATE Student SET student_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, student.getStudentName());
    }


    public void delete(int studentId) {
        String sql = "DELETE FROM Student WHERE id = ?";
        jdbcTemplate.update(sql, studentId);
    }
}

