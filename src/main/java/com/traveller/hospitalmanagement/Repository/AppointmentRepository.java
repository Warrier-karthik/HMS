package com.traveller.hospitalmanagement.Repository;


import com.traveller.hospitalmanagement.Models.Appointment;
import com.traveller.hospitalmanagement.Models.Doctor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AppointmentRepository {
    JdbcTemplate jdbcTemplate;
    public AppointmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Appointment> appointmentRowMapper = (rs, rowNum) -> {
        Appointment appointment = new Appointment();
        appointment.setDoctor_id(rs.getInt("doctor_id"));
        appointment.setPatient_id(rs.getInt("patient_id"));
        appointment.setStatus(rs.getString("status"));
        appointment.setDate(rs.getDate("appointment_date"));
        appointment.setTime(rs.getTime("appointment_time"));
        return appointment;
    };
    public List<Appointment> getAllAppointment() {
        String sql = "select * from appointments";
        return jdbcTemplate.query(sql, appointmentRowMapper);
    }
    public int addAppointment(Appointment appointment) {
        String sql = "insert into appointments(patient_id, doctor_id, appointment_date, appointment_time, status) values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, appointment.getPatient_id(), appointment.getDoctor_id(), appointment.getDate(), appointment.getTime(), appointment.getStatus());
    }
}
