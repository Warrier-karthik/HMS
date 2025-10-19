package com.traveller.hospitalmanagement.Models;


import java.util.Date;

public class RoomAllotment {
    private int room_id;
    private int patient_id;
    private int doctor_id;
    private Date date_of_admission;
    private Date date_of_discharge;
    private String status;
    private String admission_reason;

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getPatient_id() {
        return patient_id;
    }

    public void setPatient_id(int patient_id) {
        this.patient_id = patient_id;
    }

    public int getDoctor_id() {
        return doctor_id;
    }

    public void setDoctor_id(int doctor_id) {
        this.doctor_id = doctor_id;
    }

    public Date getDate_of_admission() {
        return date_of_admission;
    }

    public void setDate_of_admission(Date date_of_admission) {
        this.date_of_admission = date_of_admission;
    }

    public Date getDate_of_discharge() {
        return date_of_discharge;
    }

    public void setDate_of_discharge(Date date_of_discharge) {
        this.date_of_discharge = date_of_discharge;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAdmission_reason() {
        return admission_reason;
    }

    public void setAdmission_reason(String admission_reason) {
        this.admission_reason = admission_reason;
    }
}
