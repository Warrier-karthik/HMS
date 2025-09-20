package com.traveller.hospitalmanagement.Repository;

import com.traveller.hospitalmanagement.Models.Patient;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PatientRepository {
    private final JdbcTemplate jdbcTemplate;

    public PatientRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<Patient> patientRowMapper = (rs, rowNum) -> {
        Patient patient = new Patient();
        patient.setId(rs.getInt("patient_id"));
        patient.setFirstName(rs.getString("first_name"));
        patient.setLastName(rs.getString("last_name"));
        patient.setAddress(rs.getString("address"));
        patient.setEmail(rs.getString("email"));
        patient.setDateOfBirth(rs.getDate("dob"));
        patient.setPhoneNo(rs.getInt("phone_no"));
        return patient;
    };
    public int addPatient(Patient patient) {
        String sql = "insert into patients (first_name, last_name, dob, phone_no, email, address) values (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, patient.getFirstName(), patient.getLastName(), patient.getDateOfBirth(), patient.getPhoneNo(), patient.getEmail(), patient.getAddress());
    }
    public List<Patient> getAllPatients() {
        String sql = "select * from patients";
        return jdbcTemplate.query(sql, patientRowMapper);

    }
    public List<Patient> getPatientbyphNo(String phNo) {
        String sql = "select * from patients where phone_no = ?";
        return jdbcTemplate.query(sql, patientRowMapper, phNo);
    }
    public List<Patient> getPatientsByName(String name) {
        String sql = "select * from patients where first_name = ? OR last_name = ?";
        return jdbcTemplate.query(sql, patientRowMapper, name, name);
    }
    public Patient getPatientById(int id) {
        String sql = "select * from patients where patient_id = ?";
        return jdbcTemplate.queryForObject(sql, patientRowMapper, id);
    }
}

