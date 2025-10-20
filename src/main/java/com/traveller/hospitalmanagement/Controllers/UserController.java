package com.traveller.hospitalmanagement.Controllers;

import com.traveller.hospitalmanagement.Models.User;
import com.traveller.hospitalmanagement.Services.UserService;
import com.traveller.hospitalmanagement.dto.LoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("*")
public class UserController {
    UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @PreAuthorize("hasAnyRole('ADMIN', 'MANAGER')")
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
