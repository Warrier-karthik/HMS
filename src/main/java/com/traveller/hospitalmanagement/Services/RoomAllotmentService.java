package com.traveller.hospitalmanagement.Services;


import com.traveller.hospitalmanagement.Models.RoomAllotment;
import com.traveller.hospitalmanagement.Repository.RoomAllotmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomAllotmentService {
    RoomAllotmentRepository roomAllotmentRepository;
    public RoomAllotmentService(RoomAllotmentRepository roomAllotmentRepository) {
        this.roomAllotmentRepository = roomAllotmentRepository;
    }

    public List<RoomAllotment> getAllRoomAllotment() {
        return roomAllotmentRepository.getAllAllotments();
    }
    public int saveRoomAllotment(RoomAllotment roomAllotment) {
        return roomAllotmentRepository.createAllotment(roomAllotment);
    }
}
