package com.traveller.hospitalmanagement.Services;


import com.traveller.hospitalmanagement.Models.RoomAllotment;
import com.traveller.hospitalmanagement.Repository.RoomAllotmentRepository;
import com.traveller.hospitalmanagement.dto.RoomAllotmentDTO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAllotmentService {
    RoomAllotmentRepository roomAllotmentRepository;
    DoctorService doctorService;
    PatientService patientService;
    RoomService roomService;
    public RoomAllotmentService(RoomAllotmentRepository roomAllotmentRepository,
                                DoctorService doctorService,
                                PatientService patientService,
                                RoomService roomService) {
        this.roomAllotmentRepository = roomAllotmentRepository;
        this.doctorService = doctorService;
        this.patientService = patientService;
        this.roomService = roomService;
    }

    public List<RoomAllotment> getAllRoomAllotment() {
        return roomAllotmentRepository.getAllAllotments();
    }
    public int saveRoomAllotment(RoomAllotmentDTO roomAllotmentDTO) {
        System.out.println(STR."roomAllotmentDTO: \{roomAllotmentDTO.getRoomNo()}");
        RoomAllotment roomAllotment = new RoomAllotment();
        System.out.println("why the f"+ roomService.getRoom(roomAllotmentDTO.getRoomNo()).getRoom_id());
        roomAllotment.setRoom_id(roomService.getRoom(roomAllotmentDTO.getRoomNo()).getRoom_id());
        roomAllotment.setStatus(roomAllotmentDTO.getStatus());
        roomAllotment.setDoctor_id(doctorService.getDoctorByName(roomAllotmentDTO.getDoctorName()).getUser_id());
        roomAllotment.setPatient_id(patientService.getPatientByName(roomAllotmentDTO.getPatientName()).getId());
        roomAllotment.setDate_of_admission(roomAllotmentDTO.getAdmissionDate());
        return roomAllotmentRepository.createAllotment(roomAllotment);
    }
}
