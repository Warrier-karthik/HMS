package com.traveller.hospitalmanagement.Services;


import com.traveller.hospitalmanagement.Models.Appointment;
import com.traveller.hospitalmanagement.Models.Doctor;
import com.traveller.hospitalmanagement.Models.Patient;
import com.traveller.hospitalmanagement.Repository.AppointmentRepository;
import com.traveller.hospitalmanagement.dto.AppointmentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AppointmentService {
    AppointmentRepository appointmentRepository;
    DoctorService doctorService;
    PatientService patientService;
    public AppointmentService(AppointmentRepository appointmentRepository,
                              DoctorService doctorService,
                              PatientService patientService) {
        this.appointmentRepository = appointmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
    }

    public List<AppointmentDTO> getAllAppointments() {
        List<AppointmentDTO> newAppointments =  new ArrayList<>();
        List<Appointment> allAppointments = appointmentRepository.getAllAppointment();
        for (Appointment appointment: allAppointments) {
            AppointmentDTO appointmentDTO = new AppointmentDTO();
            Doctor currentDoctor = doctorService.getDoctorById(appointment.getDoctor_id());
            Patient currentPatient = patientService.getPatientById(appointment.getPatient_id());
            appointmentDTO.setDoctorName(STR."Dr.\{currentDoctor.getFirstName()} \{currentDoctor.getLastName()}");
            appointmentDTO.setPatientName(STR."\{currentPatient.getFirstName()} \{currentPatient.getLastName()}");
            appointmentDTO.setDate(appointment.getDate());
            appointmentDTO.setStatus(appointment.getStatus());
            appointmentDTO.setTime(appointment.getTime());
            newAppointments.add(appointmentDTO);
        }
        return newAppointments;
    }
    public int addAppointment(Appointment appointment) {
        return appointmentRepository.addAppointment(appointment);
    }
}
