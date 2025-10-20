package com.traveller.hospitalmanagement.Controllers;


import com.traveller.hospitalmanagement.Models.RoomAllotment;
import com.traveller.hospitalmanagement.Services.RoomAllotmentService;
import com.traveller.hospitalmanagement.dto.RoomAllotmentDTO;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class RoomAllotmentController {
    RoomAllotmentService roomAllotmentService;
    public RoomAllotmentController(RoomAllotmentService roomAllotmentService) {
        this.roomAllotmentService = roomAllotmentService;
    }

    @GetMapping("/room/getAllotments")
    public List<RoomAllotment> getAllAllotments() {
        return roomAllotmentService.getAllRoomAllotment();
    }
    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
    @PostMapping("/room/makeAllotment")
    public int setRoomAllotment(@RequestBody RoomAllotmentDTO roomAllotment) {
        System.out.println(roomAllotment.getRoomNo());
        System.out.println(roomAllotment.getAdmissionDate());
        return roomAllotmentService.saveRoomAllotment(roomAllotment);
    }
}
