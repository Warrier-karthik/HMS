package com.traveller.hospitalmanagement.Services;

import com.traveller.hospitalmanagement.Config.SecurityConfig;
import com.traveller.hospitalmanagement.Models.CustomUserDetails;
import com.traveller.hospitalmanagement.Models.Doctor;
import com.traveller.hospitalmanagement.Models.User;
import com.traveller.hospitalmanagement.Repository.DoctorRepository;
import com.traveller.hospitalmanagement.Repository.UserRepository;
import com.traveller.hospitalmanagement.dto.LoginDTO;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;

@Service
public class UserService {
    UserRepository userRepository;
    DoctorRepository doctorRepository;
    SecurityConfig securityConfig;
    AuthenticationManager authenticationManager;
    public UserService(UserRepository userRepository, SecurityConfig securityConfig, DoctorRepository doctorRepository, AuthenticationManager authenticationManager) {
        this.userRepository = userRepository;
        this.securityConfig = securityConfig;
        this.doctorRepository = doctorRepository;
        this.authenticationManager = authenticationManager;
    }

    public void createUser(User user) {
        User newUser = new User();
        Doctor doctor = new Doctor();
        String hashedPassword = securityConfig.passwordEncoder().encode(user.getPassword());
        newUser.setPassword(hashedPassword);
        newUser.setUsername(user.getUsername());
        newUser.setUserID(user.getUserID());
        newUser.setUser_type(user.getUser_type());
        if (user.getUser_type().equals("Doctor")) {
            doctor.setUser_id(user.getUserID());
            doctor.setDept(user.getDoctor().getDept());
            doctor.setStatus(user.getDoctor().getStatus());
            doctor.setFirstName(user.getDoctor().getFirstName());
            doctor.setLastName(user.getDoctor().getLastName());
            int ret = doctorRepository.createDoctor(doctor);
            System.out.println(ret);
        }
        System.out.println(user.getUsername());
        System.out.println(newUser.getUsername());
        int ret = userRepository.createUser(newUser);
        System.out.println(ret);
    }
    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }

    public String authenticate(LoginDTO loginDTO) {
        try {
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginDTO.getUsername(),
                            loginDTO.getPassword()
                    )
            );
            CustomUserDetails customUserDetails = (CustomUserDetails) authentication.getPrincipal();
            return STR."login successful\{customUserDetails.getUsername()}";
        } catch(BadCredentialsException e) {
            return  "Incorrect username or password";
        }

    }
}
