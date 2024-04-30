package com.example.academicsappjdbc.dao;
import com.example.academicsappjdbc.models.ClassGroup;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class ClassGroupRowMapper implements RowMapper<ClassGroup> {
    @Override
    public ClassGroup mapRow(ResultSet rs, int rowNum) throws SQLException {
        ClassGroup classGroup = new ClassGroup();
        classGroup.setId(rs.getInt("id"));
        classGroup.setClassGroupName(rs.getString("class_group_name"));
        classGroup.setFacultyId(rs.getInt("faculty_id"));
        classGroup.setCourseId(rs.getInt("course_id"));
        return classGroup;
    }
}

