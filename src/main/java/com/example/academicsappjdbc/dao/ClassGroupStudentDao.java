package com.example.academicsappjdbc.dao;

import com.example.academicsappjdbc.models.ClassGroupStudent;
import com.example.academicsappjdbc.models.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassGroupStudentDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    public List<Student> getAllStudentsInClassGroup(Integer classGroupId){
        String sql = "SELECT s.* FROM Student s JOIN ClassGroup_Student cgs ON s.id = cgs.student_id WHERE cgs.class_group_id = ?";
        return jdbcTemplate.query(sql, new Object[]{classGroupId}, new StudentRowMapper());
    }

    public void addStudentToClassGroup(Integer classGroupId, Integer studentId){
        String sql = "INSERT INTO ClassGroup_Student (class_group_id, student_id) VALUES (?, ?)";
         jdbcTemplate.update(sql, classGroupId, studentId);
    }

    public void removeStudentsFromClassGroup(Integer classGroupId, Integer studentId){
        String sql = "DELETE FROM ClassGroup_Student WHERE class_group_id = ? AND student_id = ?";
        jdbcTemplate.update(sql, classGroupId, studentId);
    }
}