package com.traveller.hospitalmanagement.Repository;
import com.traveller.hospitalmanagement.Models.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class DoctorRepository {
    private final JdbcTemplate jdbcTemplate;
    public DoctorRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Doctor> doctorRowMapper = (rs, rowNum) -> {
        Doctor doctor = new Doctor();
        doctor.setDept(rs.getString("dept"));
        doctor.setFirstName(rs.getString("first_name"));
        doctor.setLastName(rs.getString("last_name"));

        doctor.setStatus(rs.getString("status"));
        doctor.setUser_id(rs.getInt("doctor_id"));
        return doctor;
    };


    public int createDoctor(Doctor doctor) {
        String sql = "insert into doctors (first_name, last_name, dept, status) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, doctor.getFirstName(), doctor.getLastName(), doctor.getStatus(), doctor.getDept());
    }
    public List<Doctor> allDoctors() {
        String sql = "select * from doctors";
        return jdbcTemplate.query(sql, doctorRowMapper);
    }
    public Doctor getDoctorById(int id) {
        String sql = "select * from doctors where doctor_id=?";
        return jdbcTemplate.queryForObject(sql, doctorRowMapper, id);
    }

    public Doctor getDoctorByName(String name) {
        String sql = "select * from doctors where first_name=? or last_name=?";
        return jdbcTemplate.queryForObject(sql, doctorRowMapper, name, name);
    }
    public List<Doctor> getDoctorwithName(String name) {
        String sql = "select * from doctors where first_name=? or last_name=?";
        return jdbcTemplate.query(sql, doctorRowMapper, name, name);
    }
    public List<Doctor> getDoctorwithDept(String dept) {
        String sql = "select * from doctors where dept=?";
        return jdbcTemplate.query(sql, doctorRowMapper, dept);
    }

}
