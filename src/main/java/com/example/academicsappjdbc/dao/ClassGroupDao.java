package com.example.academicsappjdbc.dao;

import com.example.academicsappjdbc.models.ClassGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ClassGroupDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;


    public ClassGroup findById(int classGroupId) {
        String sql = "SELECT * FROM ClassGroup WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{classGroupId}, new ClassGroupRowMapper());
    }


    public List<ClassGroup> findAll() {
        String sql = "SELECT * FROM ClassGroup";
        return jdbcTemplate.query(sql, new ClassGroupRowMapper());
    }


    public void save(ClassGroup classGroup) {
        String sql = "INSERT INTO ClassGroup (class_group_name, faculty_id, course_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, classGroup.getClassGroupName(), classGroup.getFacultyId(), classGroup.getCourseId());
    }


    public void update(ClassGroup classGroup) {
        String sql = "UPDATE ClassGroup SET class_group_name = ?, faculty_id = ?, course_id = ? WHERE id = ?";
        jdbcTemplate.update(sql, classGroup.getClassGroupName(), classGroup.getFacultyId(), classGroup.getCourseId(), classGroup.getId());
    }


    public void delete(int classGroupId) {
        String sql = "DELETE FROM ClassGroup WHERE id = ?";
        jdbcTemplate.update(sql, classGroupId);
    }

    public void updateFacultyOfClassGroup(Integer classGroupId, Integer facultyId){
        String sql = "UPDATE ClassGroup  SET faculty_id = ? WHERE id = ?";;
        jdbcTemplate.update(sql,facultyId,classGroupId);
    }
}

