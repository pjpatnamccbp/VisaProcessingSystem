package com.virtusa.visaprocessingsystem.controllers;

import com.virtusa.visaprocessingsystem.dto.AuthRequest;
import com.virtusa.visaprocessingsystem.dto.UserRegistrationDto;
import com.virtusa.visaprocessingsystem.services.JwtService;
import com.virtusa.visaprocessingsystem.services.UserRegistraionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/visa/users")
@AllArgsConstructor
public class UserRegistrationController {
    private UserRegistraionService userRegistraionService;

    @Autowired
    private JwtService jwtService;

    @PostMapping("/register")
    public ResponseEntity<UserRegistrationDto> saveUser(@RequestBody UserRegistrationDto userRegistrationDto){
        return new ResponseEntity<>(userRegistraionService.saveUser(userRegistrationDto), HttpStatus.CREATED);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<UserRegistrationDto> updateUser(@PathVariable("id") Long userId,
                                                          @RequestBody UserRegistrationDto userRegistrationDto){
        return new ResponseEntity<>(userRegistraionService.updateUser(userId,userRegistrationDto), HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<UserRegistrationDto>> getAllUsers(){
        return new ResponseEntity<>(userRegistraionService.getAllUsers(),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId){
        return new ResponseEntity<>(userRegistraionService.deleteUserById(userId),HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserRegistrationDto> getUserById(@PathVariable("id") Long userId){
        return new ResponseEntity<>(userRegistraionService.getUserById(userId),HttpStatus.OK);
    }

    @PostMapping("/authenticate")
    public String authenticateAndGetToken(@RequestBody AuthRequest authRequest){
        String token = jwtService.generateToken(authRequest.getUserName());
        System.out.println(token);
        //return jwtService.generateToken(authRequest.getUserName());
        return token;
    }

}
