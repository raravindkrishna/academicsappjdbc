package com.example.academicsappjdbc.dao;
import com.example.academicsappjdbc.models.Faculty;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
public class FacultyRowMapper implements RowMapper<Faculty> {
    @Override
    public Faculty mapRow(ResultSet rs, int rowNum) throws SQLException {
        Faculty faculty = new Faculty();
        faculty.setId(rs.getInt("id"));
        faculty.setFacultyName(rs.getString("faculty_name"));

        return faculty;
    }
}
