package com.traveller.hospitalmanagement.Repository;

import com.traveller.hospitalmanagement.Config.SecurityConfig;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.traveller.hospitalmanagement.Models.User;

import java.util.List;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;

    public UserRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private final RowMapper<User> userMapper = (rs, rowNum) -> {
        User user = new User();
        user.setUserID((int) rs.getLong("user_id"));
        user.setUser_type(rs.getString("user_type"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password_hash"));
        return user;
    };

    public User getUserbyName(String username) {
        String sql = "select * from users where username = ?";
        return jdbcTemplate.queryForObject(sql, userMapper, username);
    }

    public int createUser(User user) {
        String sql = "insert into users (username, password_hash, user_type) values (?, ?, ?)";
        return jdbcTemplate.update(sql, user.getUsername(), user.getPassword(), user.getUser_type());

    }

    public List<User> getAllUsers() {
        String sql = "select * from users";
        return jdbcTemplate.query(sql, userMapper);
    }

    public String getpasswordByuserName(String username) {
        String sql = "select password_hash from users where username = ?";
        return jdbcTemplate.queryForObject(sql, String.class, username);
    }
}
