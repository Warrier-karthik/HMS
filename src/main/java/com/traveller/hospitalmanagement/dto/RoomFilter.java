package com.traveller.hospitalmanagement.dto;

import java.util.Optional;

public class RoomFilter {
    private String status;
    private Integer rate;
    private String roomType;
    private Integer floor;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;

    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(Integer rate) {
        this.rate = rate;
    }

    public String getRoomType() {
        return roomType;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }
}
