package com.traveller.hospitalmanagement.Controllers;


import com.traveller.hospitalmanagement.Models.Room;
import com.traveller.hospitalmanagement.Services.RoomService;
import com.traveller.hospitalmanagement.dto.RoomFilter;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoomController {
    RoomService roomService;
    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }
    @GetMapping("/room/allRooms")
    public List<Room> getAllRooms(){
        return roomService.getAllRooms();
    }
    @PreAuthorize("hasRole('MANAGER')")
    @PostMapping("/room/createRoom")
    public int createRoom(@RequestBody Room room){
        return roomService.createRoom(room);
    }
    @GetMapping("/room/room")
    public List<Room> getRooms(RoomFilter roomFilter) {
        return roomService.filterRooms(roomFilter);
    }

}
