package com.example.academicsappjdbc.dao;
import com.example.academicsappjdbc.models.Student;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class StudentRowMapper implements RowMapper<Student> {
    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
        Student student = new Student();
        student.setId(rs.getInt("id"));
        student.setStudentName(rs.getString("student_name"));
        student.setRollNo(rs.getString("roll_no"));
        return student;
    }
}
