package com.traveller.hospitalmanagement.Services;

import com.traveller.hospitalmanagement.Models.Doctor;
import com.traveller.hospitalmanagement.Repository.DoctorRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorService {
    DoctorRepository doctorRepository;

    public DoctorService(DoctorRepository doctorRepository) {
        this.doctorRepository = doctorRepository;
    }

    public List<Doctor> getAllDoctors() {
        return doctorRepository.allDoctors();
    }

    public Doctor getDoctorById(int id) {
        return doctorRepository.getDoctorById(id);
    }


    public List<Doctor> getDoctor(String type, String value) {
        return switch (type.toLowerCase()) {
            case "name" -> doctorRepository.getDoctorwithName(value);
            case "dept" -> doctorRepository.getDoctorwithDept(value);
            default -> List.of();
        };
    }
    public Doctor getDoctorByName(String name) {
        return doctorRepository.getDoctorByName(name);
    }
}