package com.example.academicsappjdbc.dao;
import com.example.academicsappjdbc.models.ClassGroupStudent;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ClassGroupStudentRowMapper implements RowMapper<ClassGroupStudent> {
    @Override
    public ClassGroupStudent mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClassGroupStudent classGroupStudent = new ClassGroupStudent();
        classGroupStudent.setId(rs.getInt("id"));
        classGroupStudent.setClassGroupId(rs.getInt("class_group_id"));
        classGroupStudent.setStudentId(rs.getInt("student_id"));
        return classGroupStudent;
    }
}

