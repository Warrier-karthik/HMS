package com.traveller.hospitalmanagement.Controllers;

import com.traveller.hospitalmanagement.Models.Patient;
import com.traveller.hospitalmanagement.Services.PatientService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PatientController {
    PatientService patientService;
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @PostMapping("/patient/new")
    public int newPatient(@RequestBody Patient patient) {
        return patientService.makePatient(patient);
    }
    @GetMapping("/patient/allPatients")
    public List<Patient> getAllPatients() {
        return patientService.allPatients();
    }
    @GetMapping("/patient/patient")
    public List<Patient> getAllPatientsById(@RequestParam String type, @RequestParam String value) {
        return patientService.getPatient(type, value);
    }
}
