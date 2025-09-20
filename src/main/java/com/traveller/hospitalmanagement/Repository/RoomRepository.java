package com.traveller.hospitalmanagement.Repository;

import com.traveller.hospitalmanagement.Models.Room;
import com.traveller.hospitalmanagement.dto.RoomFilter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RoomRepository {
    private final JdbcTemplate jdbcTemplate;
    public RoomRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    private final RowMapper<Room> rowMapper = (rs, rowNum) -> {
        Room room = new Room();
        room.setRoom_number(rs.getInt("room_number"));
        room.setRoom_type(rs.getString("room_type"));
        room.setFloor(rs.getInt("floor"));
        room.setStatus(rs.getString("status"));

        return room;
    };

    public int createRoom(Room room) {
        String sql = "insert into rooms (room_number, room_type, floor, status) values (?, ?, ?, ?)";
        return jdbcTemplate.update(sql, room.getRoom_number(), room.getRoom_type(), room.getFloor(), room.getStatus());
    }
    public List<Room> getAllRooms() {
        String sql = "select * from rooms";
        return jdbcTemplate.query(sql, rowMapper);

    }
    public List<Room> find(RoomFilter roomFilter) {
        StringBuilder sql = new StringBuilder("select * from rooms where 1=1");
        List<Object> params = new ArrayList<>();
        if (roomFilter.getStatus() != null) {
            sql.append(" and status = ?");
            params.add(roomFilter.getFloor());
        }
        if (roomFilter.getRoomType() != null) {
            sql.append(" and room_type = ?");
            params.add(roomFilter.getRoomType());
        }
        if (roomFilter.getFloor() != null) {
            sql.append(" and floor = ?");
            params.add(roomFilter.getFloor());
        }
        if (roomFilter.getRate() != null) {
            sql.append(" and room_type = ?");
            params.add(roomFilter.getRate());
        }

     return jdbcTemplate.query(sql.toString(), params.toArray(), rowMapper);
    }
}
