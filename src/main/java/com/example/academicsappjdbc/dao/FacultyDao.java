package com.example.academicsappjdbc.dao;

import com.example.academicsappjdbc.models.Faculty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FacultyDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public Faculty findById(int facultyId) {
        String sql = "SELECT * FROM Faculty WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{facultyId}, new FacultyRowMapper());
    }


    public List<Faculty> findAll() {
        String sql = "SELECT * FROM Faculty";
        return jdbcTemplate.query(sql, new FacultyRowMapper());
    }


    public void save(Faculty faculty) {
        String sql = "INSERT INTO Faculty (faculty_name) VALUES (?)";
        jdbcTemplate.update(sql, faculty.getFacultyName());
    }


    public void update(Faculty faculty) {
        String sql = "UPDATE Faculty SET faculty_name = ? WHERE id = ?";
        jdbcTemplate.update(sql, faculty.getFacultyName(), faculty.getId());
    }


    public void delete(int facultyId) {
        String sql = "DELETE FROM Faculty WHERE id = ?";
        jdbcTemplate.update(sql, facultyId);
    }
}
