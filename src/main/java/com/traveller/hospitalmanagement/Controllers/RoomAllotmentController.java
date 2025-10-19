package com.traveller.hospitalmanagement.Controllers;


import com.traveller.hospitalmanagement.Models.RoomAllotment;
import com.traveller.hospitalmanagement.Services.RoomAllotmentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomAllotmentController {
    RoomAllotmentService roomAllotmentService;
    public RoomAllotmentController(RoomAllotmentService roomAllotmentService) {
        this.roomAllotmentService = roomAllotmentService;
    }

    @GetMapping("/room/getAllotments")
    public List<RoomAllotment> getAllAllotments() {
        return roomAllotmentService.getAllRoomAllotment();
    }
    @PostMapping("/room/makeAllotment")
    public int setRoomAllotment(@RequestBody RoomAllotment roomAllotment) {
        return roomAllotmentService.saveRoomAllotment(roomAllotment);
    }
}
