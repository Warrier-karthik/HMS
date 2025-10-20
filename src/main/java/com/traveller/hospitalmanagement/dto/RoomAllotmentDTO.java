package com.traveller.hospitalmanagement.dto;


import java.util.Date;

public class RoomAllotmentDTO {
    private int roomNo;
    private String doctorName;
    private String patientName;
    private Date AdmissionDate;
    private Date DischargeDate;
    private String status;

    public int getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(int roomNo) {
        this.roomNo = roomNo;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public Date getAdmissionDate() {
        return AdmissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        AdmissionDate = admissionDate;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public Date getDischargeDate() {
        return DischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        DischargeDate = dischargeDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
