package com.traveller.hospitalmanagement.Controllers;

import com.traveller.hospitalmanagement.Models.User;
import com.traveller.hospitalmanagement.Services.UserService;
import com.traveller.hospitalmanagement.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }
    @GetMapping("/users/allUsers")
    public List<User> getUsers() {
        return userService.getAllUsers();
    }
    @PostMapping("user/login")
    public String login(@RequestBody LoginDTO loginDTO) {
        return userService.authenticate(loginDTO);
    }
}
