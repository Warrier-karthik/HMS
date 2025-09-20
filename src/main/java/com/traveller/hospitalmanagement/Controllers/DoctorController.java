package com.traveller.hospitalmanagement.Controllers;

import com.traveller.hospitalmanagement.Models.Doctor;
import com.traveller.hospitalmanagement.Services.DoctorService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class DoctorController {
    DoctorService doctorService;

    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping("/doctor/allDoctors")
    public List<Doctor> allDoctors() {
        return doctorService.getAllDoctors();
    }
    @GetMapping("/doctor/doctor")
    public List<Doctor> getDoctor(@RequestParam String type, @RequestParam String value) {
        return doctorService.getDoctor(type, value);
    }
}










