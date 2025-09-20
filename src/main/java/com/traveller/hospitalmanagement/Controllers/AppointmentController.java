package com.traveller.hospitalmanagement.Controllers;



import com.traveller.hospitalmanagement.Models.Appointment;
import com.traveller.hospitalmanagement.Services.AppointmentService;
import com.traveller.hospitalmanagement.dto.AppointmentDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AppointmentController {
    AppointmentService appointmentService;
    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }
    @GetMapping("/appointment/allAppointments")
    public List<AppointmentDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }

    @PostMapping("/appointment/setAppointment")
    public int setAppointment(@RequestBody Appointment appointment) {
        return appointmentService.addAppointment(appointment);
    }
}
