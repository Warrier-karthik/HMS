package com.traveller.hospitalmanagement.Services;


import com.traveller.hospitalmanagement.Models.Patient;
import com.traveller.hospitalmanagement.Repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientService {
    PatientRepository patientRepository;
    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }
    public int makePatient(Patient patient) {
        return patientRepository.addPatient(patient);
    }
    public List<Patient> allPatients() {
        return patientRepository.getAllPatients();
    }

    public List<Patient> getPatient(String type, String value) {
        return switch (type.toLowerCase()) {
            case "name" -> patientRepository.getPatientsByName(value);
            case "phone" -> patientRepository.getPatientbyphNo(value);
            default -> List.of();
        };
    }
    public Patient getPatientById(int id) {
        return patientRepository.getPatientById(id);
    }
    public  Patient getPatientByName(String name) {
        return patientRepository.getPatientByName(name);
    }

}
