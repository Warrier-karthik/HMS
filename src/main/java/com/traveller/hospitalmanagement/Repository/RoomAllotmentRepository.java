package com.traveller.hospitalmanagement.Repository;


import com.traveller.hospitalmanagement.Models.RoomAllotment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoomAllotmentRepository {
    JdbcTemplate jdbcTemplate;
    public RoomAllotmentRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<RoomAllotment> RoomAllotmentRower = (rs, rowNum) -> {
        RoomAllotment roomAllotment = new RoomAllotment();
        roomAllotment.setRoom_id(rs.getInt("room_id"));
        roomAllotment.setPatient_id(rs.getInt("patient_id"));
        roomAllotment.setStatus(rs.getString("status"));
        roomAllotment.setAdmission_reason(rs.getString("admission_reason"));
        roomAllotment.setDoctor_id(rs.getInt("doctor_id"));
        roomAllotment.setDate_of_admission(rs.getDate("admission_date"));
        roomAllotment.setDate_of_discharge(rs.getDate("discharge_date"));
        return roomAllotment;
    };
    public int createAllotment(RoomAllotment roomAllotment) {
        String sql = "insert into room_assignments (room_id, patient_id, doctor_id, admission_date, discharge_date, status, admission_reason) values (?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql, roomAllotment.getRoom_id(), roomAllotment.getPatient_id(), roomAllotment.getDoctor_id(), roomAllotment.getDate_of_admission(), roomAllotment.getDate_of_discharge(), roomAllotment.getStatus(), roomAllotment.getAdmission_reason());
    }

    public List<RoomAllotment> getAllAllotments() {
        String sql = "select * from room_assignments";
        return jdbcTemplate.query(sql, RoomAllotmentRower);
    }
}
