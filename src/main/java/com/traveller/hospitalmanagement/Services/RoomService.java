package com.traveller.hospitalmanagement.Services;


import com.traveller.hospitalmanagement.Models.Room;
import com.traveller.hospitalmanagement.Repository.RoomRepository;
import com.traveller.hospitalmanagement.dto.RoomFilter;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public List<Room> getAllRooms(){
        return roomRepository.getAllRooms();
    }
    public int createRoom(Room room){
        return roomRepository.createRoom(room);
    }
    public List<Room> filterRooms(RoomFilter roomFilter){
        return roomRepository.find(roomFilter);
    }
    public Room getRoom(int room_number) {
        return roomRepository.getRoom(room_number);
    }
}
